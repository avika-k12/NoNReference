import java.util.*;

class Child {
    private String name;
    private String address;
    private String naughtyOrNice; // "Naughty" or "Nice"
    private String present;

    // Constructor
    public Child(String name, String address, String naughtyOrNice, String present) {
        setName(name);
        setAddress(address);
        setNaughtyOrNice(naughtyOrNice);
        setPresent(present);
    }

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getNaughtyOrNice() { return naughtyOrNice; }
    public String getPresent() { return present; }

    // Setters with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        this.address = address.trim();
    }

    public void setNaughtyOrNice(String naughtyOrNice) {
        if (naughtyOrNice == null ||
                (!naughtyOrNice.equalsIgnoreCase("Naughty") && !naughtyOrNice.equalsIgnoreCase("Nice"))) {
            throw new IllegalArgumentException("Status must be 'Naughty' or 'Nice'.");
        }
        this.naughtyOrNice = naughtyOrNice.substring(0,1).toUpperCase() + naughtyOrNice.substring(1).toLowerCase();
    }

    public void setPresent(String present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Status: " + naughtyOrNice + ", Present: " + present;
    }
}
