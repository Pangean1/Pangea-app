pragma solidity ^0.8.0;

// Imports ERC721 and Counters libraries from the OpenZeppelin standard 
import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/utils/Counters.sol";

// The "mint" function is used to create a new NFT and assign it to a specific address. 
// It increments the token ID using the Counters library, mints the new token, and returns the token ID.
    function mint(address to) public returns (uint256) {
        _tokenIdTracker.increment();
        uint256 newTokenId = _tokenIdTracker.current();
        _mint(to, newTokenId);
        return newTokenId;
    }

