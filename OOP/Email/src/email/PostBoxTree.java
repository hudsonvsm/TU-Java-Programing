package email;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PostBoxTree implements IOInterface {
    private Collection<EMail> inboundEmails;
    private Collection<EMail> outboundEmails;

    public PostBoxTree(Collection<EMail> inboundEmails, Collection<EMail> outboundEmails) {
        this.inboundEmails = inboundEmails;
        this.outboundEmails = outboundEmails;
    }

    public Collection<EMail> getInboundEmailCollection() {
        return this.inboundEmails;
    }

    public Collection<EMail> getOutboundEmailCollection() {
        return this.outboundEmails;
    }

    public void fillOut(Collection<EMail> fromColl)
    {
        this.getOutboundEmailCollection().addAll(fromColl);
    }

    public List<EMail> providerSort() {
        Collections.sort((List<EMail>) this.getInboundEmailCollection(), new Comparator<EMail>() {
            @Override
            public int compare(EMail o1, EMail o2) {
                return o1.compareToId(o2.getProvider());
            }
        });

        return (List<EMail>) this.getInboundEmailCollection();
    }

    public List<EMail> messageSort() {
        Collections.sort((List<EMail>) this.getInboundEmailCollection(), new Comparator<EMail>() {
            @Override
            public int compare(EMail o1, EMail o2) {
                return o1.compareToMessage(o2.getEMailMessage());
            }
        });

        return (List<EMail>) this.getInboundEmailCollection();
    }

    @Override
    public void read()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void write()
    {
        // TODO Auto-generated method stub

    }
}
