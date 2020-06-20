class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};


    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter = 0;

        private Iterator() {
        }

        public boolean hasNext(){
            if (names.length>counter) {return true;
            }else return false;

            
        }
        public String next(){
            return names[counter++];
        }
    }

}
