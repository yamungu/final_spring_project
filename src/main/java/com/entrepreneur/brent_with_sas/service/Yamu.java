//package com.entrepreneur.brent_with_sas.service;
//
//public class Yamu {
//    package com.entrepreneur.brent_with_sas.service;
//
//    public class OrderService {
//        @Entity
//        public class Entrepreneur {
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long entrepreneurId;
//            private String name;
//            private String email;
//            private String password;
//            private String address;
//            private String phoneNumber;
//
//            @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
//            private List<com.entrepreneur.brent_with_sas.service.OrderService.Order> orders;
//
//            @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
//            private List<com.entrepreneur.brent_with_sas.service.OrderService.Feedback> feedbacks;
//
//            // Getters and setters
//        }
//        @Entity
//        public class Supplier {
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long supplierId;
//            private String name;
//            private String email;
//            private String password;
//            private String address;
//            private String phoneNumber;
//
//            @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
//            private List<com.entrepreneur.brent_with_sas.service.OrderService.Product> products;
//
//            // Getters and setters
//        }
//        @Entity
//        public class Product {
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long productId;
//            private String name;
//            private String description;
//            private double price;
//            private int stockQuantity;
//
//            @ManyToOne
//            @JoinColumn(name = "supplier_id")
//            private com.entrepreneur.brent_with_sas.service.OrderService.Supplier supplier;
//
//            @ManyToMany(mappedBy = "products")
//            private List<com.entrepreneur.brent_with_sas.service.OrderService.Order> orders;
//
//            @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//            private List<com.entrepreneur.brent_with_sas.service.OrderService.ProductLocation> locations;
//
//            @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//            private List<com.entrepreneur.brent_with_sas.service.OrderService.Feedback> feedbacks;
//
//            // Getters and setters
//        }
//        @Entity
//        public class Order {
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long orderId;
//            private LocalDate orderDate;
//            private LocalDate deliveryDate;
//            private String status;
//
//            @ManyToOne
//            @JoinColumn(name = "entrepreneur_id")
//            private com.entrepreneur.brent_with_sas.service.OrderService.Entrepreneur entrepreneur;
//
//            @ManyToMany
//            @JoinTable(
//                    name = "order_product",
//                    joinColumns = @JoinColumn(name = "order_id"),
//                    inverseJoinColumns = @JoinColumn(name = "product_id"))
//            private List<com.entrepreneur.brent_with_sas.service.OrderService.Product> products;
//
//            // Getters and setters
//        }
//        @Entity
//        public class OrderProduct {
//            @EmbeddedId
//            private com.entrepreneur.brent_with_sas.service.OrderService.OrderProductKey id;
//
//            @ManyToOne
//            @MapsId("orderId")
//            @JoinColumn(name = "order_id")
//            private com.entrepreneur.brent_with_sas.service.OrderService.Order order;
//
//            @ManyToOne
//            @MapsId("productId")
//            @JoinColumn(name = "product_id")
//            private com.entrepreneur.brent_with_sas.service.OrderService.Product product;
//
//            private int quantity;
//
//            // Getters and setters
//        }
//        @Embeddable
//        public class OrderProductKey implements Serializable {
//            private Long orderId;
//            private Long productId;
//
//            // Getters, setters, hashCode, equals
//        }
//        @Entity
//        public class ProductLocation {
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long locationId;
//            private double latitude;
//            private double longitude;
//            private LocalDateTime timestamp;
//
//            @ManyToOne
//            @JoinColumn(name = "product_id")
//            private com.entrepreneur.brent_with_sas.service.OrderService.Product product;
//
//            // Getters and setters
//        }
//        @Entity
//        public class Feedback {
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long feedbackId;
//            private String content;
//            private int rating;
//            private LocalDateTime timestamp;
//
//            @ManyToOne
//            @JoinColumn(name = "entrepreneur_id")
//            private com.entrepreneur.brent_with_sas.service.OrderService.Entrepreneur entrepreneur;
//
//            @ManyToOne
//            @JoinColumn(name = "product_id")
//            private com.entrepreneur.brent_with_sas.service.OrderService.Product product;
//
//            // Getters and setters
//        }
//
//


