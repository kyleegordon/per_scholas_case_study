package perscholas.casestudy.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceEnrollFormBean {

    private Integer id;

    private boolean deviceManagement;

    private boolean identityManagement;

    private boolean networkManagement;

    private boolean proactiveServices;

    private boolean pci;

    private boolean hiipa;

    private boolean pii;
}
