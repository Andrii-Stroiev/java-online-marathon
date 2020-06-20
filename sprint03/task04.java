public enum LineType {
    SOLID, DOTTED, DASHED, DOUBLE;
}


    public static String drawLine(LineType lineType) {
        String message = null;
        switch (lineType) {
            case SOLID:
                message = "The line is solid type";
            break;
            case DOTTED:
                message  ="The line is dotted type";
            break;
            case DASHED:
                message = "The line is dashed type";
            break;
            case DOUBLE:
                message = "The line is double type";
            break;
        }
    return message;
    }
