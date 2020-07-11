public static String readFile(String filename) {
        String result = "";
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            String binaryString = new String(bytes);
            for (int i = 0; i < binaryString.length(); i += 7) {
                result += (char) Integer.parseInt(binaryString.substring(0 + i, 7 + i), 2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
