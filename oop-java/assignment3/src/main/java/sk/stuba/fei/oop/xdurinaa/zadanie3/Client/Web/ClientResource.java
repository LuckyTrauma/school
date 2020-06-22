package sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Web;
import com.sun.nio.sctp.IllegalReceiveException;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Address;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Client;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class ClientResource {
        @Min(0)
        private long clientID;
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private String surname;
        @NotNull
        @NotEmpty
        private String birth;
        @NotNull
        @NotEmpty
        @Email
        private String email;
        @NotNull
        @Min(0)
        private int ZIP;
        @NotNull
        @NotEmpty
        private String City;
        @NotNull
        @NotEmpty
        private String Street;
        @NotNull
        @Min(0)
        private int HouseNumber;

        private boolean separateCrpAddress;

        private int crpAddressZip;
        private String crpAddressCity;
        private String crpAddressStreet;
        private int crpAddressHouseNumber;

        public ClientResource(Client client)
        {
            if(client == null) throw new IllegalArgumentException("Cannot create resource from user null");
            this.setClientID(client.getClientID());
            this.setName(client.getName());
            this.setSurname(client.getSurname());
            this.setBirth(client.getBirth());
            this.setEmail(client.getEmail());

            this.setAddress(client.getAddress());

            if(client.hasSeparateCrpAddress())
            {
                this.setSeparateCrpAddress(true);
                this.setCorrespondenceAddress(client.getCorrespAddress());
            }
        }

        public Address getAddress()
        {
            return new Address(this.ZIP, this.City, this.Street, this.HouseNumber);
        }

        public void setAddress(Address address)
        {
            if(address == null) throw new IllegalReceiveException("Cannot set residence address null");
            this.setZIP(address.getZIP());
            this.setCity(address.getCity());
            this.setStreet(address.getStreet());
            this.setHouseNumber(address.getHouseNumber());
        }

        public Address getCorrespondenceAddress()
        {
            if(this.separateCrpAddress)
                return new Address(this.crpAddressZip, this.crpAddressCity, this.crpAddressStreet, this.crpAddressHouseNumber);
            return null;
        }

        public void setCorrespondenceAddress(Address address)
        {
            if(address == null) throw new IllegalArgumentException("Cannot set correspondence address null");
            this.setCrpAddressZip(address.getZIP());
            this.setCrpAddressCity(address.getCity());
            this.setCrpAddressStreet(address.getStreet());
            this.setCrpAddressHouseNumber(address.getHouseNumber());
        }

        public Client modifyClient(Client client)
        {
            if(client == null) throw new IllegalArgumentException("Cannot edit client null");
            client.setName(this.name);
            client.setSurname(this.surname);
            client.setEmail(this.email);
            client.setAddress(this.getAddress());
            client.setCorrespAddress(this.getCorrespondenceAddress());
            return client;
        }

        public Client createNewClient()
        {
            return new Client(this.name, this.surname, this.birth,this.getAddress(), this.getCorrespondenceAddress(), this.email);
        }
    }

