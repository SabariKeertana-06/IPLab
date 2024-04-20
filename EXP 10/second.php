<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Armstrong Number Checker</title>
</head>
<body>
    <h2>Armstrong Number Checker</h2>

    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        <label for="number">Enter a number:</label>
        <input type="number" id="number" name="number" required>
        <input type="submit" value="Check">
    </form>

    <?php
    // Function to check if a number is an Armstrong number
    function isArmstrong($number) {
        $numDigits = strlen((string)$number);
        $sum = 0;
        $originalNumber = $number;

        while ($number > 0) {
            $digit = $number % 10;
            $sum += pow($digit, $numDigits);
            $number = (int)($number / 10);
        }

        return $sum === $originalNumber;
    }

    // Process form submission
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $inputNumber = $_POST["number"];

        if ($inputNumber > 0 && filter_var($inputNumber, FILTER_VALIDATE_INT)) {
            if (isArmstrong($inputNumber)) {
                echo "<p>$inputNumber is an Armstrong number!</p>";
            } else {
                echo "<p>$inputNumber is not an Armstrong number.</p>";
            }
        } else {
            echo "<p>Please enter a valid positive integer.</p>";
        }
    }
    ?>

</body>
</html>
