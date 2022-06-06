package model;

public class CpuWithGpu extends Cpu {

    public CpuWithGpu(String serialNumber, int coreNumber) {
        super(serialNumber, coreNumber);
    }

    public void addLink_subset(String roleName, String reverseRoleName,
                               String superRoleName, Cpu targetObject) throws Exception {
        if (isLink(superRoleName, targetObject)) {

            addLink(roleName, reverseRoleName, targetObject, 1);
        } else {
            throw new Exception("couldn't find link");
        }
    }

}
