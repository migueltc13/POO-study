// Exercise 3
public class Phone {

    private String brand;
    private String model;
    private int displayX;
    private int displayY;
    private int storageMessages;
    private int storagePhotos;
    private int storageApps;
    private int storagePhotosApps;
    private int storageUsed; // bytes
    private int countFotos;
    private int countApps;
    private String[] messages;
    private String[] apps;

    /* Constructures */
    public Phone() {
        this.brand = "Apple";
        this.model = "iPhone 12";
        this.displayX = 2532;
        this.displayY = 1170;
        this.storageMessages = 100;
        this.storagePhotos = 100;
        this.storageApps = 100;
        this.storagePhotosApps = 100;
        this.storageUsed = 0;
        this.countFotos = 0;
        this.countApps = 0;
        this.messages = new String[storageMessages];
        this.apps = new String[storageApps];
    }

    public Phone(
        String brand,
        String model,
        int displayX,
        int displayY,
        int storageMessages,
        int storagePhotos,
        int storageApps,
        int storagePhotosApps)
    {
        this.brand = brand;
        this.model = model;
        this.displayX = displayX;
        this.displayY = displayY;
        this.storageMessages = storageMessages;
        this.storagePhotos = storagePhotos;
        this.storageApps = storageApps;
        this.storagePhotosApps = storagePhotosApps;
        this.storageUsed = 0;
        this.countFotos = 0;
        this.countApps = 0;
        this.messages = new String[storageMessages];
        this.apps = new String[storageApps];
    }

    public Phone(Phone phone) {
        /* this.brand = phone.getBrand();
        this.model = phone.getModel();
        this.displayX = phone.getDisplayX();
        this.displayY = phone.getDisplayY();
        this.storageMessages = phone.getStorageMessages();
        this.storagePhotos = phone.getStoragePhotos();
        this.storageApps = phone.getStorageApps();
        this.storagePhotosApps = phone.getStoragePhotosApps();
        this.storageUsed = phone.getStorageUsed();
        this.countFotos = phone.getCountFotos();
        this.countApps = phone.getCountApps();
        this.messages = phone.getMessages();
        this.apps = phone.getApps(); */
    }

    /* instance methods */
    /* ... */

    // (a)
    public boolean existeEspaco(int numeroBytes) {
        return (this.storageUsed + numeroBytes) <= (this.storageMessages + this.storagePhotosApps);
    }

    // (b)
    public void instalaApp(String nome, int tamanho) {
        if (existeEspaco(tamanho)) {
            this.apps[this.countApps++] = nome;
            this.storageUsed += tamanho;
        }
    }

    // (c)
    public void recebeMsg(String msg) {
        if (msg == null) return;
        if (existeEspaco(msg.length())) {
            this.messages[this.countFotos++] = msg;
            this.storageUsed += msg.length();
        }
    }

    // (d)
    public double tamMedioApps() {
        return (double) this.storageApps / this.countApps;
    }

    // (e)
    public String maiorMsg() {
        String maior = "";
        for (String msg : this.messages) {

            if (msg != null && msg.length() > maior.length()) {
                maior = msg;
            }
        }
        return maior;
    }

    // (f)
    public void removeApp(String nome, int tamanho) {
        for (int i = 0; i < this.countApps; i++) {
            if (this.apps[i].equals(nome)) {
                this.apps[i] = null;
                this.storageUsed -= tamanho;
                this.countApps--;
                // shift left
                for (int j = i; j < this.countApps; j++) {
                    this.apps[j] = this.apps[j + 1];
                }
                this.apps[this.countApps] = null;
                break;
            }
        }
    }

    public static void main(String[] args) {

        Phone p1 = new Phone();
        Phone p2 = new Phone(
            "Samsung",
            "Galaxy S21",
            2400,
            1080,
            200,
            200,
            200,
            200);
        Phone p3 = new Phone(p2);

        System.out.println(p1.existeEspaco(100));
        System.out.println(p2.existeEspaco(100));
        System.out.println(p3.existeEspaco(100));

        p1.instalaApp("WhatsApp", 50);
        p1.instalaApp("Instagram", 50);
        p1.instalaApp("Facebook", 50);
        p1.instalaApp("Twitter", 100);

        // recebeMsg
        p1.recebeMsg("Hello, world!");
        p2.recebeMsg("Hi!");

        System.out.println(p1.tamMedioApps());
        System.out.println(p1.maiorMsg());

        p1.removeApp("Instagram", 50);
        p1.removeApp("Facebook", 50);

        System.out.println(p1.storageUsed);
    }
}
