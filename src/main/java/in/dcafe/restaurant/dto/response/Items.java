package in.dcafe.restaurant.dto.response;


import java.util.List;


public record Items(
         Long itemId,
         String itemName,
         List<String> category,
         String dietary,
         String type,
         double price,
         List<String> restaurants
) {}
