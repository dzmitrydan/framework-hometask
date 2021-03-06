package servise;

import model.InstancesForm;
import util.StringExtractor;

public class InstancesFormCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.instancesform.numberofinstances";
    public static final String WHAT_ARE_THESE_INSTANCES_FOR = "testdata.instancesform.whataretheseinstancesfor";
    public static final String OPERATING_SYSTEM_SOFTWARE = "testdata.instancesform.operatingsystemsoftware";
    public static final String MACHINE_CLASS = "testdata.instancesform.machineclass";
    public static final String MACHINE_TYPE = "testdata.instancesform.machinetype";
    public static final String CHECK_ADD_GPUS = "testdata.instancesform.checkaddgpus";
    public static final String NUMBER_OF_GPUS = "testdata.instancesform.numberofgpus";
    public static final String GPU_TYPE = "testdata.instancesform.gputype";
    public static final String LOCAL_SSD = "testdata.instancesform.localssd";
    public static final String DATACENTER_LOCATION = "testdata.instancesform.datacenterlocation";
    public static final String COMMITED_USAGE = "testdata.instancesform.commitedusage";

    public static InstancesForm withCredentialsFromProperty() {
        return new InstancesForm(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(WHAT_ARE_THESE_INSTANCES_FOR),
                TestDataReader.getTestData(OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(CHECK_ADD_GPUS)),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE));
    }

    public static InstancesForm withEmptyWhatAreTheseInstances() {
        return new InstancesForm(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                "",
                TestDataReader.getTestData(OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(CHECK_ADD_GPUS)),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE));
    }

    public static InstancesForm withNotIntegerInputValueOfNumberOfInstances() {
        return new InstancesForm("four",
                TestDataReader.getTestData(WHAT_ARE_THESE_INSTANCES_FOR),
                TestDataReader.getTestData(OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(CHECK_ADD_GPUS)),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE));
    }

    public static InstancesForm estimateComputeEnginePopupData(String machineClass,
                                                               String machineType,
                                                               String datacenterLocation,
                                                               String commitedUsage) {

        String machineClassConverted = StringExtractor.stringCapitalize(StringExtractor.deleteTextBeforeColon(machineClass));
        String machineTypeConverted = StringExtractor.deleteTextBeforeColon(machineType);
        String datacenterLocationConverted = StringExtractor.deleteTextBeforeColon(datacenterLocation);
        String commitedUsageConverted = StringExtractor.deleteTextBeforeColon(commitedUsage);

        return new InstancesForm(machineClassConverted,
                machineTypeConverted,
                datacenterLocationConverted,
                commitedUsageConverted);
    }

}
