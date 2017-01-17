package email;

import java.util.TreeSet;

public class Main
{
    public static void main(String[] args)
    {
        TreeSet<EMail> one = new TreeSet<EMail>();
        TreeSet<EMail> two = new TreeSet<EMail>();

        PostBox o1 = new PostBox(one, two);
        o1.getMessage("dataIn.txt");

        o1.providerSort();
        System.out.println(o1.getInboundEmails());
        o1.messageSort();
        System.out.println(o1.getInboundEmails());

        PostBox o2 = new PostBox(one, two);
        o2.fillOut(o1.getInboundEmails());

        o2.composeMessage("dataOut.txt");

        EMail test = new EMail("4-asdbaasdtkir3@abv.bg:=aaTest Message 4");
        System.out.println(test.toString());

    }

}
