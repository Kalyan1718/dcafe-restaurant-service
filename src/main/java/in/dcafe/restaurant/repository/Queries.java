package in.dcafe.restaurant.repository;


public class Queries {

    public static final String ITEMS_BY_NAME_QUERY = """
                SELECT i.*, r.restaurant_name as restaurants FROM item i
                JOIN restaurant_items ri ON i.item_id = ri.item_id
                JOIN restaurant r ON ri.restaurant_id = r.restaurant_id
                WHERE i.item_name=?
                """;

    public static final String ITEMS_QUERY = """
                SELECT i.*, r.restaurant_name as restaurants FROM item i
                LEFT JOIN restaurant_items ri ON i.item_id = ri.item_id
                LEFT JOIN restaurant r ON ri.restaurant_id = r.restaurant_id
                """;
}
