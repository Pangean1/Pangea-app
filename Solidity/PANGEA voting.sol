pragma solidity ^0.5.0;

contract Voting {

    struct vote{
        address voterAddress;
        bool choice;
    }
    
    struct voter{
        string voterName;
        bool voted;
    }

    uint private countResult = 0;
    uint public finalResult = 0;
    uint public totalVoter = 0;
    uint public totalVote = 0;
    address public voteOfficialAddress;      
    string public voteOfficialName;
    string public proposal;
    
    mapping(uint => vote) private votes;
    mapping(address => voter) public voterRegister;
    
    enum State { Created, Voting, Ended }
	State public state;
	
	//creates a new Vote contract
	constructor(
        string memory _voteOfficialName,
        string memory _proposal) public {
        voteOfficialAddress = msg.sender;
        voteOfficialName = _voteOfficialName;
        proposal = _proposal;
        state = State.Created;
    }

	modifier onlyOfficial() {
		require(msg.sender == voteOfficialAddress);
		_;
	}

	modifier inState(State _state) {
		require(state == _state);
		_;
	}

    event voterAdded(address voter);
    event voteStarted();
    event voteEnded(uint finalResult);
    event voteDone(address voter);
    
    //add voter
    function addVoter(address _voterAddress, string memory _voterName)
        public
        inState(State.Created)
        onlyOfficial
    {
        voter memory v;
        v.voterName = _voterName;
        v.voted = false;
        voterRegister[_voterAddress] = v;
        totalVoter++;
        emit voterAdded(_voterAddress);
    }

    //declare voting starts now
    function startVote()
        public
        inState(State.Created)
        onlyOfficial
    {
        state = State.Voting;     
        emit voteStarted();
    }

    //voters vote by indicating their choice (true/false)
    function doVote(bool _choice)
        public
        inState(State.Voting)
        returns (bool voted)
    {
        bool found = false;
        
        if (bytes(voterRegister[msg.sender].voterName).length != 0 
        && !voterRegister[msg.sender].voted){
            voterRegister[msg.sender].voted = true;
            vote memory v;
            v.voterAddress = msg.sender;
            v.choice = _choice;
            if (_choice){
                countResult++; //counting on the go
            }
            votes[totalVote] = v;
            totalVote++;
            found = true;
        }
        emit voteDone(msg.sender);
        return found;
    }
    
    //end votes
    function endVote()
        public
        inState(State.Voting)
        onlyOfficial
    {
        state = State.Ended;
        finalResult = countResult; //move result from private countResult to public finalResult
        emit voteEnded(finalResult);
    }
}