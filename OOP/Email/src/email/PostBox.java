package email;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PostBox implements IPost {
    private Collection<EMail> inboundEmails;
    private Collection<EMail> outboundEmails;

    public PostBox(Collection<EMail> inboundEmails, Collection<EMail> outboundEmails) {
        this.inboundEmails = inboundEmails;
        this.outboundEmails = outboundEmails;
    }

    public Collection<EMail> getInboundEmails() {
        return this.inboundEmails;
    }

    public Collection<EMail> getOutboundEmails() {
        return this.outboundEmails;
    }

    public List<EMail> providerSort() {
        Collections.sort((List<EMail>) this.getInboundEmails(), new Comparator<EMail>() {
            @Override
            public int compare(EMail o1, EMail o2) {
                return o1.compareToId(o2.getProvider());
            }
        });

        return (List<EMail>) this.getInboundEmails();
    }

    public List<EMail> messageSort() {
        Collections.sort((List<EMail>) this.getInboundEmails(), new Comparator<EMail>() {
            @Override
            public int compare(EMail o1, EMail o2) {
                return o1.compareToMessage(o2.getEMailMessage());
            }
        });

        return (List<EMail>) this.getInboundEmails();
    }

    public void fillOut(Collection<EMail> emailCollection) {
        this.getOutboundEmails().addAll(emailCollection);
    }

    @Override
    public void composeMessage(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("Cannot find file: " + f.getAbsolutePath());
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));

            for (EMail cl : this.getOutboundEmails()) {
                writer.write(cl.toString());
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Exception while write: " + e);
        }
    }

    @Override
    public void getMessage(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("Cannot find file: " + f.getAbsolutePath());
            return;
        }

        try {
            LineNumberReader reader = new LineNumberReader(new FileReader(f));
            String line = null;

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                this.inboundEmails.add(new EMail(line));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

}
