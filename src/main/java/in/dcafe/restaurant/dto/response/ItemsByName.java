package in.dcafe.restaurant.dto.response;

import java.util.List;

public record ItemsByName(
         Long itemId,
         List<String> category,
         String dietary,
         String itemName,
         double price,
         String type,
         List<String> restaurants
) {}
