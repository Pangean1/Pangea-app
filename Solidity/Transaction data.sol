pragma solidity ^0.8.0;

contract TransactionData {
    ERC20 public token;

    constructor(address _token) {
        token = ERC20(_token);
    }

    function detectNewTransaction(address myAddress) public view returns (bool) {
        bytes32 topic = keccak256("Transfer(address,address,uint256)");
        uint fromBlock = block.number - 10000; // hardcode: start searching from 10000 blocks ago
        uint toBlock = block.number;
        bool result = false;

        for (uint i = fromBlock; i < toBlock; i++) {
            bytes32[] memory topics = new bytes32[](1);
            topics[0] = topic;
            uint limit = 1;
            uint offset = 0;

            (uint count, uint blockNumber) = token.filterTopics(topics, myAddress, limit, offset, block.number);

            if (count > 0 && blockNumber > fromBlock) {
                result = true;
                break;
            }
        }

        return result;
    }
}
