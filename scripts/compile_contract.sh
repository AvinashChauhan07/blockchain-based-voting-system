
#!/bin/bash
# Use web3j to generate Java wrappers. Requires web3j CLI installed.
echo "Compile and generate Java wrapper (requires solc + web3j)"
solc --bin --abi -o build/contracts src/main/smart-contract/Voting.sol
web3j solidity generate -b build/contracts/Voting.bin -a build/contracts/Voting.abi -o src/main/java -p com.dvs.project.blockchain
