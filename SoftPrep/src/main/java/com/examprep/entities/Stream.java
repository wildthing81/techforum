package com.examprep.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EP_STREAM")
public class Stream {

        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="streamidgenerator")
        @SequenceGenerator(name="streamidgenerator",sequenceName="STREAMID_SQ",allocationSize=1)
        @Column(name="stream_id")
	private long streamID;
        @Column(name="stream_name")
	private String streamName;
        @OneToMany(mappedBy = "parentStream")
	private List<QuestionBank> memberQBanks;

    public long getStreamID() {
        return streamID;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public List<QuestionBank> getMemberQBanks() {
        return memberQBanks;
    }

    public void setMemberQBanks(List<QuestionBank> memberQBanks) {
        this.memberQBanks = memberQBanks;
    }
	
	
	
}
