# Assessment 1 - README
#### At its core, this program is a basic console-based Inventory Management System. This system will allow the user to manage a variety of products: Electronics, Clothing, and Groceries.

## Overview
#### This is an object-oriented inventory management system that was designed to demonstrate the core Java programming concepts. Users can add new products, view the inventory, find items by searching for them by their name within the inventory, and digitally update the product price. The system comes preloaded with some sample products, allowing the user to experiment without having to add Data on their own.

## Features
#### The application has a total of three product categories: Electronics, Clothing, and Groceries. Each category contains its own unique attributes that differentiate them while still sharing the common properties, such as a name and price. The system is providing a simple text-based menu interface for moving between options.

## Technologies Used
#### The Assessment 1 is written in the Java language, it works only in the terminal, and works with standard input and output with the User. It uses the core object-oriented programming concepts, such as inheritance, polymorphism, and encapsulation. All input data is processed using the Scanner Library. While it is apparent that all Data is stored in an ArrayList.  

## Design Details
#### The system contains a base class named Product that holds the general information about a product, such as the product's Name and Price. Specialized classes, such as Electronics, Clothing, and Grocery, are the sub-classes that extend from the base class and include all the additional attributes unique to a specific type of product. Each sub-class of the Product class overrides the displayProduct() method in order to display their own details.
#### To maintain private data, no fields are public. The ProductManager class handles a list of products and product actions such as adding, displaying, searching and updating. For the purpose of demonstration I've added some sample products as the program starts.
