<?php
$servername = "localhost"; 
$username = "your_username";
$password = "your_password";
$dbname = "subscribe"; 

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$name = $_POST['name'] ?? '';
$email = $_POST['email'] ?? '';
$plan = $_POST['plan'] ?? '';

if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    die("Invalid email format");
}

$stmt = $conn->prepare("INSERT INTO subscriptions (name, email, plan) VALUES (?, ?, ?)");
$stmt->bind_param("sss", $name, $email, $plan);

if ($stmt->execute()) {
    echo "Subscription successful!";
} else {
    echo "Error: " . $stmt->error;
}

$stmt->close();
$conn->close();
?>
