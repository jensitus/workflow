package at.phactum.workflow.cockpit;

import lombok.Getter;

@Getter
public enum UiUriType {

    EXTERNAL("EXTERNAL"),
    WEBPACK_MF_REACT("WEBPACK_MF_REACT");

    private final String value;

    UiUriType(final String value) {
        this.value = value;
    }

}
