package model;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Cpu {
    private String serialNumber;
    private int coreNumber;
    private Map<String, Map<CpuWithGpu, Cpu>> subset = new Hashtable<>();

    public boolean isLink(String roleName, Cpu cpu) {
        Map<CpuWithGpu, Cpu> objectLink;
        if (!subset.containsKey(roleName)) {
            return false;
        }
        objectLink = subset.get(roleName);
        return objectLink.containsValue(cpu);
    }

    public Cpu(String serialNumber, int coreNumber) {
        this.serialNumber = serialNumber;
        this.coreNumber = coreNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }


    public void addLink(String roleName, String reverseRoleName, Cpu cpu, Object qualifier) {
        addLink(roleName, reverseRoleName, cpu, qualifier, 2);
    }

    // non - qualified
    public void addLink(String roleName, String reverseRoleName, Cpu cpu) {
        addLink(roleName, reverseRoleName, cpu, cpu);
    }

    private void addLink(String roleName, String reverseRoleName, Cpu cpu, Object qualifier, int counter) {
        Map<CpuWithGpu, Cpu> objectLinks;

        // Protection for the reverse connection
        if (counter < 1) {
            return;
        }

        if (subset.containsKey(roleName)) {
            objectLinks = subset.get(roleName);
        } else {
            objectLinks = new HashMap<>();
            subset.put(roleName, objectLinks);
        }

        if (!objectLinks.containsKey(qualifier)) {
            objectLinks.put((CpuWithGpu) qualifier, cpu);

            cpu.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

}
