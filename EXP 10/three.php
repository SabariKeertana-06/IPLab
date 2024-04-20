<?php

class Product
{
    private $name;
    private $price;
    private $quantity;
    private $category;

    public function __construct($name, $price, $quantity, $category)
    {
        $this->name = $name;
        $this->price = $price;
        $this->quantity = $quantity;
        $this->category = $category;
    }


    public static function addProduct($name, $price, $quantity, $category)
    {
        return new Product($name, $price, $quantity, $category);
    }

    public function updateProduct($name, $price, $quantity, $category)
    {
        $this->name = $name;
        $this->price = $price;
        $this->quantity = $quantity;
        $this->category = $category;
    }

    public function deleteProduct()
    {
    }

    public function getName()
    {
        return $this->name;
    }

    public function setName($name)
    {
        $this->name = $name;
    }

    public function getPrice()
    {
        return $this->price;
    }

    public function setPrice($price)
    {
        $this->price = $price;
    }

    public function getQuantity()
    {
        return $this->quantity;
    }

    public function setQuantity($quantity)
    {
        $this->quantity = $quantity;
    }

    public function getCategory()
    {
        return $this->category;
    }

    public function setCategory($category)
    {
        $this->category = $category;
    }
}
$newProduct = Product::addProduct('Laptop', 1200, 5, 'Electronics');
$newProduct->updateProduct('Updated Laptop', 1300, 3, 'Electronics');
echo "Product Name: " . $newProduct->getName() . "<br>";
echo "Price: $" . $newProduct->getPrice() . "<br>";
echo "Quantity: " . $newProduct->getQuantity() . "<br>";
echo "Category: " . $newProduct->getCategory() . "<br>";
$newProduct->deleteProduct();

?>

