package com.dvs.project.blockchain;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;


/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.7.0.
 */
@SuppressWarnings("rawtypes")
public class Voting extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b50610d6a8061001c5f395ff3fe608060405234801561000f575f5ffd5b5060043610610060575f3560e01c806309eef43e1461006457806326541b56146100945780632d35a8a2146100b05780633477ee2e146100ce5780633eb76b9c14610101578063ff9810991461011d575b5f5ffd5b61007e6004803603810190610079919061059a565b61014d565b60405161008b91906105df565b60405180910390f35b6100ae60048036038101906100a99190610734565b61016a565b005b6100b8610238565b6040516100c591906107c2565b60405180910390f35b6100e860048036038101906100e39190610805565b61023e565b6040516100f89493929190610890565b60405180910390f35b61011b60048036038101906101169190610805565b610375565b005b61013760048036038101906101329190610805565b610513565b60405161014491906107c2565b60405180910390f35b6002602052805f5260405f205f915054906101000a900460ff1681565b60015f81548092919061017c9061090e565b9190505550604051806080016040528060015481526020018381526020018281526020015f8152505f5f60015481526020019081526020015f205f820151815f015560208201518160010190816101d39190610b52565b5060408201518160020190816101e99190610b52565b50606082015181600301559050507fe64f834082661dd9ed89427b87edb6270fd6dad17198b0938f0edd058914c87f600154838360405161022c93929190610c21565b60405180910390a15050565b60015481565b5f602052805f5260405f205f91509050805f01549080600101805461026290610982565b80601f016020809104026020016040519081016040528092919081815260200182805461028e90610982565b80156102d95780601f106102b0576101008083540402835291602001916102d9565b820191905f5260205f20905b8154815290600101906020018083116102bc57829003601f168201915b5050505050908060020180546102ee90610982565b80601f016020809104026020016040519081016040528092919081815260200182805461031a90610982565b80156103655780601f1061033c57610100808354040283529160200191610365565b820191905f5260205f20905b81548152906001019060200180831161034857829003601f168201915b5050505050908060030154905084565b60025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f9054906101000a900460ff16156103ff576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103f690610cae565b60405180910390fd5b5f8111801561041057506001548111155b61044f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161044690610d16565b60405180910390fd5b5f5f8281526020019081526020015f206003015f8154809291906104729061090e565b9190505550600160025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f6101000a81548160ff021916908315150217905550803373ffffffffffffffffffffffffffffffffffffffff167f4d99b957a2bc29a30ebd96a7be8e68fe50a3c701db28a91436490b7d53870ca460405160405180910390a350565b5f5f5f8381526020019081526020015f20600301549050919050565b5f604051905090565b5f5ffd5b5f5ffd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f61056982610540565b9050919050565b6105798161055f565b8114610583575f5ffd5b50565b5f8135905061059481610570565b92915050565b5f602082840312156105af576105ae610538565b5b5f6105bc84828501610586565b91505092915050565b5f8115159050919050565b6105d9816105c5565b82525050565b5f6020820190506105f25f8301846105d0565b92915050565b5f5ffd5b5f5ffd5b5f601f19601f8301169050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b61064682610600565b810181811067ffffffffffffffff8211171561066557610664610610565b5b80604052505050565b5f61067761052f565b9050610683828261063d565b919050565b5f67ffffffffffffffff8211156106a2576106a1610610565b5b6106ab82610600565b9050602081019050919050565b828183375f83830152505050565b5f6106d86106d384610688565b61066e565b9050828152602081018484840111156106f4576106f36105fc565b5b6106ff8482856106b8565b509392505050565b5f82601f83011261071b5761071a6105f8565b5b813561072b8482602086016106c6565b91505092915050565b5f5f6040838503121561074a57610749610538565b5b5f83013567ffffffffffffffff8111156107675761076661053c565b5b61077385828601610707565b925050602083013567ffffffffffffffff8111156107945761079361053c565b5b6107a085828601610707565b9150509250929050565b5f819050919050565b6107bc816107aa565b82525050565b5f6020820190506107d55f8301846107b3565b92915050565b6107e4816107aa565b81146107ee575f5ffd5b50565b5f813590506107ff816107db565b92915050565b5f6020828403121561081a57610819610538565b5b5f610827848285016107f1565b91505092915050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f61086282610830565b61086c818561083a565b935061087c81856020860161084a565b61088581610600565b840191505092915050565b5f6080820190506108a35f8301876107b3565b81810360208301526108b58186610858565b905081810360408301526108c98185610858565b90506108d860608301846107b3565b95945050505050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f610918826107aa565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff820361094a576109496108e1565b5b600182019050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f600282049050600182168061099957607f821691505b6020821081036109ac576109ab610955565b5b50919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f60088302610a0e7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826109d3565b610a1886836109d3565b95508019841693508086168417925050509392505050565b5f819050919050565b5f610a53610a4e610a49846107aa565b610a30565b6107aa565b9050919050565b5f819050919050565b610a6c83610a39565b610a80610a7882610a5a565b8484546109df565b825550505050565b5f5f905090565b610a97610a88565b610aa2818484610a63565b505050565b5b81811015610ac557610aba5f82610a8f565b600181019050610aa8565b5050565b601f821115610b0a57610adb816109b2565b610ae4846109c4565b81016020851015610af3578190505b610b07610aff856109c4565b830182610aa7565b50505b505050565b5f82821c905092915050565b5f610b2a5f1984600802610b0f565b1980831691505092915050565b5f610b428383610b1b565b9150826002028217905092915050565b610b5b82610830565b67ffffffffffffffff811115610b7457610b73610610565b5b610b7e8254610982565b610b89828285610ac9565b5f60209050601f831160018114610bba575f8415610ba8578287015190505b610bb28582610b37565b865550610c19565b601f198416610bc8866109b2565b5f5b82811015610bef57848901518255600182019150602085019450602081019050610bca565b86831015610c0c5784890151610c08601f891682610b1b565b8355505b6001600288020188555050505b505050505050565b5f606082019050610c345f8301866107b3565b8181036020830152610c468185610858565b90508181036040830152610c5a8184610858565b9050949350505050565b7f596f75206861766520616c726561647920766f746564000000000000000000005f82015250565b5f610c9860168361083a565b9150610ca382610c64565b602082019050919050565b5f6020820190508181035f830152610cc581610c8c565b9050919050565b7f496e76616c69642063616e6469646174650000000000000000000000000000005f82015250565b5f610d0060118361083a565b9150610d0b82610ccc565b602082019050919050565b5f6020820190508181035f830152610d2d81610cf4565b905091905056fea264697066735822122059db6389005214ed509ab3c7ca9fc4ac14c7d92b07799490faf08b7a7d51138e64736f6c634300081e0033";


    public static final String FUNC_ADDCANDIDATE = "addCandidate";

    public static final String FUNC_CANDIDATES = "candidates";

    public static final String FUNC_CANDIDATESCOUNT = "candidatesCount";

    public static final String FUNC_CASTVOTE = "castVote";

    public static final String FUNC_GETVOTES = "getVotes";

    public static final String FUNC_HASVOTED = "hasVoted";

    public static final Event CANDIDATEADDED_EVENT = new Event("CandidateAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event VOTED_EVENT = new Event("Voted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected Voting(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Voting(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CandidateAddedEventResponse> getCandidateAddedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CANDIDATEADDED_EVENT, transactionReceipt);
        ArrayList<CandidateAddedEventResponse> responses = new ArrayList<CandidateAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CandidateAddedEventResponse typedResponse = new CandidateAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.party = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static CandidateAddedEventResponse getCandidateAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(CANDIDATEADDED_EVENT, log);
        CandidateAddedEventResponse typedResponse = new CandidateAddedEventResponse();
        typedResponse.log = log;
        typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.party = (String) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<CandidateAddedEventResponse> candidateAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getCandidateAddedEventFromLog(log));
    }

    public Flowable<CandidateAddedEventResponse> candidateAddedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANDIDATEADDED_EVENT));
        return candidateAddedEventFlowable(filter);
    }

    public static List<VotedEventResponse> getVotedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(VOTED_EVENT, transactionReceipt);
        ArrayList<VotedEventResponse> responses = new ArrayList<VotedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VotedEventResponse typedResponse = new VotedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.voter = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.candidateId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static VotedEventResponse getVotedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(VOTED_EVENT, log);
        VotedEventResponse typedResponse = new VotedEventResponse();
        typedResponse.log = log;
        typedResponse.voter = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.candidateId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<VotedEventResponse> votedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getVotedEventFromLog(log));
    }

    public Flowable<VotedEventResponse> votedEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VOTED_EVENT));
        return votedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addCandidate(String _name, String _party) {
        final Function function = new Function(
                FUNC_ADDCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_party)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, String, String, BigInteger>> candidates(
            BigInteger param0) {
        final Function function = new Function(FUNC_CANDIDATES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, String, String, BigInteger>>(function,
                new Callable<Tuple4<BigInteger, String, String, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> candidatesCount() {
        final Function function = new Function(FUNC_CANDIDATESCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> castVote(BigInteger _candidateId) {
        final Function function = new Function(
                FUNC_CASTVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_candidateId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getVotes(BigInteger _candidateId) {
        final Function function = new Function(FUNC_GETVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_candidateId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> hasVoted(String param0) {
        final Function function = new Function(FUNC_HASVOTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static Voting load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Voting load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Voting load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Voting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Voting load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Voting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Voting> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Voting.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Voting> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Voting.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<Voting> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Voting.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Voting> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Voting.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

private static String getDeploymentBinary() {
    return BINARY;
}

    public static class CandidateAddedEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String name;

        public String party;
    }

    public static class VotedEventResponse extends BaseEventResponse {
        public String voter;

        public BigInteger candidateId;
    }
}
