# HibernateProject1

## Java Hibernate CRUD Project

A Java-based Hibernate project demonstrating **CRUD operations, entity relationships, and database interaction using Hibernate ORM**.

The project models a simple e-commerce system containing users, product categories, products, orders, and order details.

## Git Repository Setup

Initialize Git from the project root:

```bash
git init
git add .
git commit -m "Initial Hibernate ORM project"
git branch -M main
```

Create an empty repository on GitHub, then connect and push it:

```bash
git remote add origin https://github.com/<YOUR_USERNAME>/<YOUR_REPOSITORY>.git
git push -u origin main
```

---

## Project Overview

This project demonstrates how to use **Hibernate ORM** to map Java objects to relational database tables and perform database operations without writing SQL queries for every operation.

The project currently includes the following entities:

* **Users**
* **Category**
* **Product**
* **Orders**
* **OrderDetails**

The project demonstrates:

* Creating records
* Reading records from the database
* Updating records
* Deleting records
* Hibernate entity mapping
* Primary key generation
* Foreign key relationships
* `@ManyToOne` relationships
* `@OneToMany` relationships
* Hibernate Sessions and Transactions
* Entity persistence using `session.persist()`
* Hibernate dirty checking
* Working with `LocalDateTime`
* Database relationship management

---

## 🛠️ Technologies Used

| Technology                | Purpose                         |
| ------------------------- | ------------------------------- |
| Java                      | Application development         |
| Hibernate ORM             | Object-Relational Mapping       |
| Jakarta Persistence (JPA) | Entity annotations              |
| MySQL                     | Relational database             |
| Maven                     | Dependency management and build |
| Eclipse / IntelliJ IDEA   | Development environment         |

---

## 📂 Project Structure

```text
HibernateProject1/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── code/
│                   └── HibernateProject1/
│                       │
│                       ├── crud/
│                       │   ├── CreateCategory.java
│                       │   ├── CreateProduct.java
│                       │   ├── CreateOrders.java
│                       │   ├── CreateOrderDetails.java
│                       │   └── ...
│                       │
│                       └── entity/
│                           ├── Category.java
│                           ├── Product.java
│                           ├── Users.java
│                           ├── Orders.java
│                           └── OrderDetails.java
│
├── src/
├── resource/
│   ├── hibernate.cfg.xml
│   └── schema.sql
│
├── pom.xml
├── .gitignore
└── README.md
```

> The exact package and file structure may vary depending on the IDE and project configuration.

---

# 🗄️ Database Configuration

This project uses **MySQL** as the database.

Before running the application, make sure MySQL Server is installed and running.

Create a database for the project.

For example:

```sql
CREATE DATABASE hibernate_project;
```

You can then configure Hibernate to connect to this database.

---

# ⚙️ Hibernate Configuration

The Hibernate configuration is generally stored in:

```text
resource/hibernate.cfg.xml
```

A typical configuration looks like:

```xml
<?xml version="1.0" encoding="utf-8"?>

<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

	<session-factory>

		<!-- Database connection -->
		<property name="hibernate.connection.driver_class">
			com.mysql.cj.jdbc.Driver
		</property>

		<property name="hibernate.connection.url">
			jdbc:mysql://localhost:3306/hibernate_project
		</property>

		<property name="hibernate.connection.username">
			YOUR_DB_USERNAME
		</property>

		<property name="hibernate.connection.password">
			YOUR_DB_PASSWORD
		</property>

		<!-- Hibernate dialect -->
		<property name="hibernate.dialect">
			org.hibernate.dialect.MySQLDialect
		</property>

		<!-- Show SQL queries in console -->
		<property name="hibernate.show_sql">
			true
		</property>

		<!-- Format SQL queries -->
		<property name="hibernate.format_sql">
			true
		</property>

		<!-- Automatically create/update tables -->
		<property name="hibernate.hbm2ddl.auto">
			update
		</property>

		<!-- Entity classes -->
		<mapping class="com.code.HibernateProject1.entity.Users"/>
		<mapping class="com.code.HibernateProject1.entity.Category"/>
		<mapping class="com.code.HibernateProject1.entity.Product"/>
		<mapping class="com.code.HibernateProject1.entity.Orders"/>
		<mapping class="com.code.HibernateProject1.entity.OrderDetails"/>

	</session-factory>

</hibernate-configuration>
```

### ⚠️ Security Note

Do not commit real database passwords or other credentials to GitHub.

Replace:

```xml
YOUR_DB_USERNAME
YOUR_DB_PASSWORD
```

with your local database credentials.

If credentials are stored in a local `.env` or configuration file, make sure that file is included in `.gitignore`.

---

# 📦 Maven Setup

The project uses Maven for dependency management.

The required dependencies should be specified in:

```text
pom.xml
```

A typical Hibernate + MySQL setup includes dependencies for:

* Hibernate ORM
* Jakarta Persistence API
* MySQL Connector/J

After cloning the project, Maven will automatically download the required dependencies.

You can update the Maven project using:

```bash
mvn clean install
```

---

# 🚀 Setup Instructions

## Step 1 — Open the Project

Open the project directory containing `pom.xml`:

```bash
cd HibernateProject1
```

---

## Step 2 — Open the Project

Open the project using:

* Eclipse
* IntelliJ IDEA
* VS Code with Java extensions

If using Eclipse, import it as a **Maven Project**.

If using IntelliJ IDEA, open the project containing the `pom.xml` file.

---

## Step 3 — Configure MySQL

Start MySQL Server.

Create the database (or allow the configured connection URL to create it):

```sql
CREATE DATABASE hibernate_project;
```

Make sure the username and password in `hibernate.cfg.xml` match your local MySQL configuration.

---

## Step 4 — Update Maven Dependencies

From the project root, run:

```bash
mvn clean install
```

This downloads all required dependencies and builds the project.

---

## Step 5 — Verify Hibernate Configuration

Check:

```text
resource/hibernate.cfg.xml
```

Verify:

* Database URL
* Database name
* Username
* Password
* Hibernate dialect
* Entity mappings

The default example configuration uses MySQL on `localhost:3306`, database
`hibernate_project`, username `root`, and password `root`. Change these values
before running the application when they differ locally. The same table layout
is available in `resource/schema.sql`.

---

# ▶️ Execution Guide

The CRUD classes are responsible for performing database operations.

For example:

```text
CreateCategory.java
CreateProduct.java
CreateOrders.java
CreateOrderDetails.java
```

Each class:

1. Receives a `SessionFactory`
2. Creates a Hibernate `Session`
3. Starts a transaction
4. Performs database operations
5. Commits the transaction
6. Closes the session

The general Hibernate execution flow is:

```text
SessionFactory
      ↓
Session
      ↓
Transaction
      ↓
CRUD Operation
      ↓
Commit
      ↓
Close Session
```

---

# 👤 Users Entity

The `Users` entity represents users of the application.

It contains:

```text
id
username
password
email
role
```

The role is represented using an enum:

```java
public enum Role {
    ADMIN,
    CUSTOMER
}
```

The password is stored as a SHA-256 hash, and the role is stored as a string using:

```java
@Enumerated(EnumType.STRING)
```

---

# 📁 Category Entity

The `Category` entity represents product categories.

It contains:

```text
id
name
description
```

Each category can contain multiple products.

Relationship:

```text
Category
    │
    │ 1
    │
    │ *
    ↓
Product
```

---

# 🛍️ Product Entity

The `Product` entity contains:

```text
id
name
price
stockQuantity
category
```

The relationship is:

```java
@ManyToOne
@JoinColumn(name="category_id")
private Category category;
```

This means:

> Many products can belong to one category.

For example:

```text
Category: Cosmetics
        │
        ├── Foundation
        ├── Lipstick
        ├── Mascara
        └── Eyeliner
```

---

# 🧾 Orders Entity

The `Orders` entity contains:

```text
id
orderDate
totalAmount
users
```

The relationship with `Users` is:

```java
@ManyToOne
@JoinColumn(name="users_id")
private Users users;
```

Therefore:

> One user can have multiple orders.

Example:

```text
User
 │
 ├── Order 1
 ├── Order 2
 └── Order 3
```

---

# 📦 OrderDetails Entity

`OrderDetails` represents the products contained in an order.

It contains:

```text
id
quantity
unitPrice
orders
product
```

It has two `ManyToOne` relationships:

```java
@ManyToOne
@JoinColumn(name="orders_id")
private Orders orders;
```

and:

```java
@ManyToOne
@JoinColumn(name="product_id")
private Product product;
```

Therefore:

```text
Orders
   │
   │ 1
   │
   │ *
   ↓
OrderDetails
   │
   │ *
   │
   │ 1
   ↓
Product
```

This allows an order to contain multiple products.

---

# 🔗 Entity Relationship Overview

The overall database relationship can be represented as:

```text
                    USERS
                      │
                      │ 1
                      │
                      │ *
                    ORDERS
                      │
                      │ 1
                      │
                      │ *
                ORDER_DETAILS
                      │
                      │ *
                      │
                      │ 1
                      ↓
                   PRODUCT
                      │
                      │ *
                      │
                      │ 1
                      ↓
                  CATEGORY
```

In terms of relationships:

```text
Users       1 ─────── * Orders

Category    1 ─────── * Product

Orders      1 ─────── * OrderDetails

Product     1 ─────── * OrderDetails
```

---

# 🔄 Updating Order Details

When an `OrderDetails` record is updated, the related entities can also be updated explicitly.

For example:

```java
orderDetails.setQuantity(newQuantity);
orderDetails.setUnitPrice(newUnitPrice);

product.setPrice(newUnitPrice);

orders.setTotalAmount(totalAmount);
```

Hibernate's dirty checking detects changes made to managed entities and applies the corresponding SQL updates when the transaction is committed.

```java
session.getTransaction().commit();
```

> Note: In a real e-commerce application, `OrderDetails.unitPrice` is generally preserved as the price at the time of purchase, while `Product.price` represents the current product price. Therefore, changing one does not necessarily mean the other should change.

---

# 🧪 Example Data

After executing the CRUD operations, the database may contain data similar to:

### Users

| ID | Username  | Email                                                 | Role     |
| -: | --------- | ----------------------------------------------------- | -------- |
|  1 | admin     | [admin@example.com](mailto:admin@example.com)         | ADMIN    |
|  2 | customer1 | [customer1@example.com](mailto:customer1@example.com) | CUSTOMER |
|  3 | customer2 | [customer2@example.com](mailto:customer2@example.com) | CUSTOMER |

### Category

| ID | Name        | Description         |
| -: | ----------- | ------------------- |
|  1 | Electronics | Electronic products |
|  2 | Cosmetics   | Cosmetic products   |

### Product

| ID | Name       | Price | Stock | Category  |
| -: | ---------- | ----: | ----: | --------- |
|  1 | Foundation |   500 |     5 | Cosmetics |
|  2 | Lipstick   |   250 |    10 | Cosmetics |
|  3 | Mascara    |   350 |     8 | Cosmetics |

### Orders

| ID | Order Date | Total Amount | User      |
| -: | ---------- | -----------: | --------- |
|  1 | 2026-09-24 |          500 | customer2 |
|  2 | 2026-09-24 |          300 | customer2 |
|  3 | 2026-09-24 |          800 | customer2 |

### Order Details

| ID | Quantity | Unit Price | Order | Product    |
| -: | -------: | ---------: | ----: | ---------- |
|  1 |        1 |        300 |     2 | Lipstick   |
|  2 |        2 |        500 |     3 | Foundation |

---

# 🛠️ Common Hibernate Operations

## Create

Use:

```java
session.persist(object);
```

Example:

```java
Product product = new Product(
    "Foundation",
    500.00,
    5,
    category
);

session.persist(product);
```

---

## Read

Use:

```java
session.get(Entity.class, id);
```

Example:

```java
Product product = session.get(Product.class, 2);
```

---

## Update

Retrieve the entity and modify its values:

```java
Product product = session.get(Product.class, 2);

product.setPrice(550.00);
product.setStockQuantity(10);
```

Hibernate's dirty checking will detect the changes when the transaction is committed.

---

## Delete

Use:

```java
session.remove(product);
```

Example:

```java
Product product = session.get(Product.class, 2);

if (product != null) {
    session.remove(product);
}
```

---

# ⚠️ Common Issues

### 1. Database Connection Error

Check:

```text
hibernate.cfg.xml
```

Make sure:

* MySQL Server is running
* Database exists
* Username is correct
* Password is correct
* JDBC URL is correct

---

### 2. Entity Not Found

Make sure the entity is included in Hibernate configuration:

```xml
<mapping class="com.code.HibernateProject1.entity.Product"/>
```

---

### 3. Table Not Created

Check:

```xml
<property name="hibernate.hbm2ddl.auto">
    update
</property>
```

Hibernate can then create/update the database schema based on the entity mappings.

---

### 4. `LocalDateTime` Error

For `Orders`, the constructor expects:

```java
LocalDateTime
```

Therefore use:

```java
LocalDateTime.parse("2026-09-24T20:15:30")
```

instead of:

```java
"2026-09-24T20:15:30"
```

---

### 5. Foreign Key Errors

Make sure the referenced entity exists before creating a related entity.

For example, before creating a product:

```java
Category category = session.get(Category.class, categoryid);
```

Check:

```java
if (category == null) {
    System.out.println("Category not found");
    return;
}
```

The same principle applies when creating `Orders` and `OrderDetails`.

---

# 🔐 Security

Do not commit sensitive information such as:

* Database passwords
* API keys
* Private credentials
* Local environment files

Make sure `.env` and other local secret files are included in `.gitignore`.

Use placeholder values in example configuration files.

---

---

# 📜 License

This project is created for educational and learning purposes.

---

## 👩‍💻 Author

**Disha Dutta**

Java | Hibernate | MySQL | Backend Development

---

## ⭐ Project Highlights

* Java-based Hibernate ORM project
* MySQL database integration
* CRUD operations
* Entity-to-table mapping
* Primary key generation
* Foreign key relationships
* `ManyToOne` relationships
* `OneToMany` relationships
* Transaction management
* Hibernate dirty checking
* E-commerce-style database structure
