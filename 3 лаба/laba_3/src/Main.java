public class Main {
    public static void main(String[] args) {
        HashTable<String, Product> products = new HashTable<>(10);
        Product product1 = new Product("Phone", 329.99, 20);
        Product product2 = new Product("TV", 499.99, 19);
        Product product3 = new Product("Whelee", 99.99, 21);
        products.put("12345", product1);
        products.put("54321", product2);
        products.put("98765", product3);
        System.out.println(products.get("12345"));
        products.remove("54321");
        System.out.println(products.get("54321"));
        System.out.println(products.size());
        System.out.println(products.isEmpty());
    }
}