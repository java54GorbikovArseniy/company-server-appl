package telran.employees.net;

import telran.employees.Company;
import telran.employees.CompanyMapsImpl;
import telran.io.Persistable;
import telran.net.Protocol;
import telran.net.TcpServer;

public class CompanyServerAppl {
    private static final String FILE_NAME = "employeesTest.data";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        Company company = new CompanyMapsImpl();
        try {
            ((Persistable) company).restore(FILE_NAME);
        } catch (Exception e) {

        }
        Protocol protocol = new CompanyProtocol(company);
        TcpServer tcpServer = new TcpServer(protocol, PORT);
        tcpServer.run();
    }
}
