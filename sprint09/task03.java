public static void writeFile(String filename, String text) {
        String data = "";
        char[] charArray = text.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Integer.toBinaryString(charArray[i]).length() != 7) {
                for (int j = 0; j < 7 - Integer.toBinaryString(charArray[i]).length(); j++) {
                    data += "0";
                }
            }
            data += Integer.toBinaryString(charArray[i]);
        }
        
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
