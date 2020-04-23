package algorithm_2020.pa4;

import java.util.StringJoiner;

public class CSVData {
    String name;
    String company;
    String address;
    String zip;
    String phone;
    String email;

    public CSVData(String[] info) {
        name = info[0];
        company = info[1];
        address = info[2];
        zip = info[3];
        phone = info[4];
        email = info[5];
    }

    @Override
    public String toString() {
        return name + "\n" +
                "\t" + "Company: " + company + "\n" +
                "\t" + "Address: " + address + "\n" +
                "\t" + "Zipcode: " + zip + "\n" +
                "\t" + "Phones: " + phone + "\n" +
                "\t" + "Email: " + email;
    }

    public String saveFormat() {
        StringJoiner sj = new StringJoiner(",");
        sj.add(wrapStr(name));
        sj.add(wrapStr(company));
        sj.add(wrapStr(address));
        sj.add(wrapStr(zip));
        sj.add(wrapStr(phone));
        sj.add(wrapStr(email));

        return sj.toString();
    }

    private CharSequence wrapStr(String str) {
        if (str.contains(","))
            return "\"" + str + "\"";
        else
            return str;
    }
}
