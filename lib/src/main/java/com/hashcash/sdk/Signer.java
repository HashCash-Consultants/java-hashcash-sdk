package com.hashcash.sdk;

import com.hashcash.sdk.xdr.SignerKey;
import com.hashcash.sdk.xdr.SignerKeyType;
import com.hashcash.sdk.xdr.Uint256;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Signer is a helper class that creates {@link com.hashcash.sdk.xdr.SignerKey} objects.
 */
public class Signer {
    /**
     * Create <code>ed25519PublicKey</code> {@link com.hashcash.sdk.xdr.SignerKey} from
     * a {@link com.hashcash.sdk.KeyPair}
     * @param keyPair
     * @return com.hashcash.sdk.xdr.SignerKey
     */
    public static SignerKey ed25519PublicKey(KeyPair keyPair) {
        checkNotNull(keyPair, "keyPair cannot be null");
        return keyPair.getXdrSignerKey();
    }

    /**
     * Create <code>sha256Hash</code> {@link com.hashcash.sdk.xdr.SignerKey} from
     * a sha256 hash of a preimage.
     * @param hash
     * @return com.hashcash.sdk.xdr.SignerKey
     */
    public static SignerKey sha256Hash(byte[] hash) {
        checkNotNull(hash, "hash cannot be null");
        SignerKey signerKey = new SignerKey();
        Uint256 value = Signer.createUint256(hash);

        signerKey.setDiscriminant(SignerKeyType.SIGNER_KEY_TYPE_HASH_X);
        signerKey.setHashX(value);

        return signerKey;
    }

    /**
     * Create <code>preAuthTx</code> {@link com.hashcash.sdk.xdr.SignerKey} from
     * a {@link com.hashcash.sdk.xdr.Transaction} hash.
     * @param tx
     * @return com.hashcash.sdk.xdr.SignerKey
     */
    public static SignerKey preAuthTx(Transaction tx) {
        checkNotNull(tx, "tx cannot be null");
        SignerKey signerKey = new SignerKey();
        Uint256 value = Signer.createUint256(tx.hash());

        signerKey.setDiscriminant(SignerKeyType.SIGNER_KEY_TYPE_PRE_AUTH_TX);
        signerKey.setPreAuthTx(value);

        return signerKey;
    }

    /**
     * Create <code>preAuthTx</code> {@link com.hashcash.sdk.xdr.SignerKey} from
     * a transaction hash.
     * @param hash
     * @return com.hashcash.sdk.xdr.SignerKey
     */
    public static SignerKey preAuthTx(byte[] hash) {
        checkNotNull(hash, "hash cannot be null");
        SignerKey signerKey = new SignerKey();
        Uint256 value = Signer.createUint256(hash);

        signerKey.setDiscriminant(SignerKeyType.SIGNER_KEY_TYPE_PRE_AUTH_TX);
        signerKey.setPreAuthTx(value);

        return signerKey;
    }

    /**
     * Create <code>SignerKey</code> {@link com.hashcash.sdk.xdr.SignerKey} from {@link com.hashcash.sdk.SignedPayloadSigner}
     *
     * @param signedPayloadSigner - signed payload values
     * @return com.hashcash.sdk.xdr.SignerKey
     */
    public static SignerKey signedPayload(SignedPayloadSigner signedPayloadSigner) {

        SignerKey signerKey = new SignerKey();
        SignerKey.SignerKeyEd25519SignedPayload payloadSigner = new SignerKey.SignerKeyEd25519SignedPayload();
        payloadSigner.setPayload(signedPayloadSigner.getPayload());
        payloadSigner.setEd25519(signedPayloadSigner.getSignerAccountId().getAccountID().getEd25519());

        signerKey.setDiscriminant(SignerKeyType.SIGNER_KEY_TYPE_ED25519_SIGNED_PAYLOAD);
        signerKey.setEd25519SignedPayload(payloadSigner);

        return signerKey;
    }

    private static Uint256 createUint256(byte[] hash) {
        if (hash.length != 32) {
            throw new RuntimeException("hash must be 32 bytes long");
        }
        Uint256 value = new Uint256();
        value.setUint256(hash);
        return value;
    }
}
