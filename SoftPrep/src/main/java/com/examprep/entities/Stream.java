package com.examprep.entities;

import java.util.List;

public class Stream {

	private long streamID;
	private String streamName;
	private List<Long> memberQBanks;
	
	public String getStreamName() {
		return streamName;
	}
	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}
	public List<Long> getMemberQBanks() {
		return memberQBanks;
	}
	public void setMemberQBanks(List<Long> memberQBanks) {
		this.memberQBanks = memberQBanks;
	}
	public long getStreamID() {
		return streamID;
	}
	
	
}
