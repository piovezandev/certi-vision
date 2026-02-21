package br.com.certvision.domain.enums;

public enum IssueEnum {

    CN(1, "CN"),
    O(2, "O"),
    OU(3, "OU");

    private final Integer code;
    private final String issueName;

    IssueEnum(Integer code, String issueName) {
        this.code = code;
        this.issueName = issueName;
    }

    public Integer getCode() {
        return code;
    }

    public String getIssueName() {
        return issueName;
    }

    public IssueEnum getByCode(Integer code) {
        for (IssueEnum issueEnum : IssueEnum.values()) {
            if (issueEnum.code.equals(code)) {
                return issueEnum;
            }
        }
        throw new IllegalArgumentException("ENUM com codigo: " + code + " não encontrado");
    }
}