package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models;

public class GrantAccess {
    private Role role;
    private Account account;
    private boolean isGrant;
    private String note;

    // Constructors
    public GrantAccess() {
    }

    public GrantAccess(Role role, Account account, boolean isGrant, String note) {
        this.role = role;
        this.account = account;
        this.isGrant = isGrant;
        this.note = note;
    }

    // Getter and Setter methods
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess [role=" + role + ", account=" + account + ", isGrant=" + isGrant + ", note=" + note + "]";
    }
}
