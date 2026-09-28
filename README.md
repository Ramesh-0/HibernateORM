# HibernateProject1

## Project Overview

HibernateProject1 is a Maven-based Java application that implements an e-commerce data model using Hibernate ORM and Jakarta Persistence annotations. It manages users, categories, products, orders, and order details in a MySQL database.

## Project Structure

```text
HibernateProject1/
├── pom.xml
├── resource/
│   ├── hibernate.cfg.xml
│   └── schema.sql
├── src/
│   ├── main/java/com/code/HibernateProject1/
│   │   ├── App.java
│   │   ├── HibernateUtil.java
│   │   ├── entity/
│   │   │   ├── Category.java
│   │   │   ├── Product.java
│   │   │   ├── Users.java
│   │   │   ├── Orders.java
│   │   │   └── OrderDetails.java
│   │   └── crud/
│   │       ├── CreateCategory.java
│   │       ├── ReadCategory.java
│   │       ├── UpdateCategory.java
│   │       ├── DeleteCategory.java
│   │       ├── CreateProduct.java
│   │       ├── ReadProduct.java
│   │       ├── UpdateProduct.java
│   │       ├── DeleteProduct.java
│   │       ├── CreateUsers.java
│   │       ├── ReadUsers.java
│   │       ├── UpdateUsers.java
│   │       ├── DeleteUsers.java
│   │       ├── CreateOrders.java
│   │       ├── ReadOrders.java
│   │       ├── UpdateOrders.java
│   │       ├── DeleteOrders.java
│   │       ├── CreateOrderDetails.java
│   │       ├── ReadOrderDetails.java
│   │       ├── UpdateOrderDetails.java
│   │       └── DeleteOrderDetails.java
│   └── test/java/com/code/HibernateProject1/
│       └── AppTest.java
└── target/
    └── Maven build output
```

## Technologies

- Java 17
- Maven
- Hibernate ORM 6.3.1.Final
- Jakarta Persistence API
- MySQL Connector/J
- MySQL
- JUnit

## Entity Model

### Category

- Auto-generated `id`
- Unique, non-null `name`
- Optional `description`
- One category has many products
- Cascading and orphan removal for products

### Product

- Auto-generated `id`
- Non-null `name`
- Non-null `BigDecimal price` with decimal precision
- `stockQuantity`
- Many products belong to one category

### Users

- Auto-generated `id`
- Unique, non-null `username`
- Unique, non-null `email`
- SHA-256 hashed, non-null password
- `Role` enum with `ADMIN` and `CUSTOMER` values
- One user can have many orders

### Orders

- Auto-generated `id`
- Non-null `LocalDateTime orderDate`
- Non-null `BigDecimal totalAmount`
- Many orders belong to one user
- One order contains many order details

### OrderDetails

- Auto-generated `id`
- Non-null `quantity`
- Non-null `BigDecimal unitPrice`
- Many order details belong to one order
- Many order details can reference one product

## Entity Relationships

```text
Users       1 ─────── * Orders
Category    1 ─────── * Product
Orders      1 ─────── * OrderDetails
Product     1 ─────── * OrderDetails
```

The entity mappings use `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`, `@ManyToOne`, and `@OneToMany`. Foreign keys are non-null where a related entity is required. Collections use lazy fetching, cascading, and orphan removal where appropriate.

## CRUD Coverage

The `crud` package contains separate classes for creating, reading, updating, and deleting every entity:

| Entity | Create | Read | Update | Delete |
| --- | --- | --- | --- | --- |
| Category | Yes | Yes | Yes | Yes |
| Product | Yes | Yes | Yes | Yes |
| Users | Yes | Yes | Yes | Yes |
| Orders | Yes | Yes | Yes | Yes |
| OrderDetails | Yes | Yes | Yes | Yes |

Order creation supports multiple order details. `ReadOrders` fetches the related user, order details, and products using a Hibernate fetch-join query.

## Hibernate Configuration

Hibernate is configured in `resource/hibernate.cfg.xml`. The configuration includes:

- MySQL JDBC driver and connection URL
- Hibernate MySQL dialect
- Automatic schema update with `hibernate.hbm2ddl.auto=update`
- SQL logging and formatting
- Thread-bound current sessions
- Mappings for all five entity classes

`HibernateUtil.java` creates and exposes the shared `SessionFactory`. `schema.sql` contains the relational schema for the five entities and their foreign keys.

## Assignment Coverage

| Assignment requirement | Implementation |
| --- | --- |
| Maven project | `pom.xml` with Hibernate, MySQL, and JUnit dependencies |
| Database configuration | `resource/hibernate.cfg.xml` |
| Category entity | `Category.java` with one-to-many products |
| Product entity | `Product.java` with many-to-one category |
| Users entity | `Users.java` with roles and hashed passwords |
| Orders entity | `Orders.java` with user and order-detail relationships |
| OrderDetails entity | `OrderDetails.java` with order and product relationships |
| JPA annotations | Applied throughout the entity package |
| SessionFactory utility | `HibernateUtil.java` |
| Category, product, and user insertion | Create CRUD classes |
| Orders with multiple details | `CreateOrders.java` and `CreateOrderDetails.java` |
| Fetch orders with associations | `ReadOrders.java` fetch-join query |
| Database schema | `resource/schema.sql` |
| CRUD test structure | `src/test/java/com/code/HibernateProject1/AppTest.java` |

## Application Entry Point

`App.java` obtains the shared `SessionFactory` from `HibernateUtil` and serves as the entry point for CRUD demonstrations. CRUD operation classes can be enabled from this class as needed.
