package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {

    private String clientName;
    private int clientAge;
    private String[] clientAddresses;
    private List<String> clientFolks;
}
