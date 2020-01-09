package api;

import dto.ClientDTO;
import model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "name", target = "clientName")
    @Mapping(source = "age", target = "clientAge")
    @Mapping(source = "addresses", target = "clientAddresses")
    @Mapping(source = "folks", target = "clientFolks")
    ClientDTO clientToClientDTO(Client client);
}
