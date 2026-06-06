package models;

public class TestScenario {

    private String scenarioId;
    private String moduleName;
    private String scenarioDescription;
    private String priority;
    private String testType;
    private String requirementId;

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getScenarioDescription() {
        return scenarioDescription;
    }

    public void setScenarioDescription(
            String scenarioDescription) {

        this.scenarioDescription =
                scenarioDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(
            String requirementId) {

        this.requirementId =
                requirementId;
    }
}