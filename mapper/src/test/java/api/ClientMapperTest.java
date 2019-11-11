package api;

import dto.ClientDTO;
import model.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientMapperTest {

    @Test
    public void shouldMapClientToClientDTO() {

        Client client =
                new Client("Gnitioh Baqeccitrl", 53, new String[]{"India", "Singapore", "Malaysia", "USA"});

        ClientDTO clientDTO = api.ClientMapper.INSTANCE.clientToClientDTO(client);

        assertNotNull(clientDTO);
        assertEquals(clientDTO.getClientName(), client.getName());
        assertEquals(clientDTO.getClientAge(), client.getAge());
        assertArrayEquals(clientDTO.getClientAddresses(), client.getAddresses());
    }
}