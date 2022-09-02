package org.hashcash.sdk.responses;

import com.google.gson.annotations.SerializedName;


public class RootResponse extends Response {
    @SerializedName("aurora_version")
    private final String auroraVersion;
    @SerializedName("core_version")
    private final String hcnetCoreVersion;
    @SerializedName("history_latest_ledger")
    private final int historyLatestLedger;
    @SerializedName("history_elder_ledger")
    private final int historyElderLedger;
    @SerializedName("core_latest_ledger")
    private final int coreLatestLedger;
    @SerializedName("network_passphrase")
    private final String networkPassphrase;
    @SerializedName("protocol_version")
    private final int protocolVersion;

    public String getAuroraVersion() {
        return auroraVersion;
    }

    public String getHcnetCoreVersion() {
        return hcnetCoreVersion;
    }

    public int getHistoryLatestLedger() {
        return historyLatestLedger;
    }

    public int getHistoryElderLedger() {
        return historyElderLedger;
    }

    public int getCoreLatestLedger() {
        return coreLatestLedger;
    }

    public String getNetworkPassphrase() {
        return networkPassphrase;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public RootResponse(String auroraVersion, String hcnetCoreVersion, int historyLatestLedger, int historyElderLedger, int coreLatestLedger, String networkPassphrase, int protocolVersion) {
        this.auroraVersion = auroraVersion;
        this.hcnetCoreVersion = hcnetCoreVersion;
        this.historyLatestLedger = historyLatestLedger;
        this.historyElderLedger = historyElderLedger;
        this.coreLatestLedger = coreLatestLedger;
        this.networkPassphrase = networkPassphrase;
        this.protocolVersion = protocolVersion;
    }
}
