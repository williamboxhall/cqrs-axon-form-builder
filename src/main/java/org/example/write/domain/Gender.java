package org.example.write.domain;

public enum Gender {
    MALE,
    FEMALE,
    HERMAPHRODITE,
    TRANSGENDER,
    ABSTAIN;

    public boolean canChangeTo(Gender gender) {
        return !this.equals(gender);
    }

    public static Gender valueOfIgnoreCase(String gender) {
        return valueOf(gender.toUpperCase());
    }
}
