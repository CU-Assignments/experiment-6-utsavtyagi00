import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProcessProducts {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Smartphone", "Electronics", 800),
                new Product("Chair", "Furniture", 150),
                new Product("Table", "Furniture", 200),
                new Product("Headphones", "Electronics", 100)
        );

        // 1. Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(product -> product.category));

        System.out.println("Grouped Products by Category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        product -> product.category,
                        Collectors.maxBy(Comparator.comparingDouble(product -> product.price))
                ));

        System.out.println("\nMost Expensive Products by Category:");
        mostExpensiveByCategory.forEach((category, product) -> {
            System.out.println(category + ": " + product.orElse(null));
        });

        // 3. Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(product -> product.price)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Price of All Products: " + averagePrice);
    }
}
