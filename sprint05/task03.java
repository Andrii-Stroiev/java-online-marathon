public static Plant tryCreatePlant(String type, String color, String name) {
        try {
            Plant plant = new Plant(type, color, name);
            return plant;
        } catch (TypeException e) {
            type = "Ordinary";
        } catch (ColorException e) {
            color = "Red";
        }
        return tryCreatePlant(type, color, name);
    }
