# PANGEA´s White Paper

**1. INTRODUCTION**

Many humanitarian donations are made by individuals or philanthropic organizations to beneficiaries every day and there is a need for a transparent peer-to-peer process that allows these funds to be sent directly from one party to another in an easier, faster, secure, publicly verifiable and more traceable way.

To accomplish this, Pangea was envisioned as an independent and fully decentralized non-profit DAO built as a community to contribute with humanitarian causes and aims at its vision of "a digital world to help the real world" with empathy, respect and solidarity, guaranteeing a reliable and transparent way throughout the process and, also, without intermediaries or complex and opaque bureaucracy; mainly because donors want to make sure that all their contributions are achieving their purpose and, on the other hand, recipients want to receive these donations in full. 

Facilitating and promoting this flow whatever its size, from large to small funds, especially supporting the latter for the most part, are the objectives of Pangea, along the way feeding causes of aid, collaboration, integration, radical transparency, of a better world with social and environmental sustainability.

Current technology makes it possible and Blockchain becomes an accurate guardian of every transaction, can easily be implemented and is able to provide all reported benefits; sending and receiving funds using Cryptocurrencies without relying on human-driven intermediaries promotes important advantages such as visibility, traceability and accountability. 

**2. TRANSACTIONS**

Pangea, through its app, handles two ways to donate. 

Anonymous: donors send funds to recipients without any requirement or registration.

Registered: donors send funds to recipients with a pre-registration process.
- direct donation: donors define the amount and it is sent directly to recipients, from the registered donor's wallet to the recipient's wallet.   
- buying digital parcels: the sense of community is reinforced through the land of Pangea, where each parcel of digital land can be easily purchased and the amount of this transaction is sent directly to recipients, from the registered donor's wallet to the recipient's wallet.

Transactions with each Cryptocurrency are recorded on a publicly verifiable, timestamped and traceable Blockchain.

**3. DAO GOVERNANCE**

The system for governing the Pangea Protocol, enabled by Pangeans (GAIA Token Holder Community). GAIA is Pangea's token and grants voting rights to Pangeans. 

Pangea´s DAO is built thanks to the contributions of the Pangea developers and the participation of the Pangean community. This is the key to success; working together, in person or remotely, to define and implement best governance practices for an organizational model that improves collaborative ways to give back to others in need and help the world. 

Principles, rules, guidelines and policies must reflect a wide range of perspectives aimed at growth and benefit of the community.

The Pangea DAO community uses GAIA tokens as an incentive to DAO’s growth and a valuable asset for governance. Being rewarded with GAIAs depends on actions such as proposals, votes and donations.

- Statement 1:
GAIA template definition: tF{~d,t,m}

Variables: (reference: InterWork Alliance - IWA)
* [X] tF = fungible token
* [X] ~d = indivisible
* [X] t = transferable
* [X] m = mint

- Statement 2: a formula is needed that promotes Proposals because creating proposals about governance, code and releases allow creators to earn GAIAs.

GAIAs are given to the creator when the Proposal reaches Consensus, and a formula rules it.

Formula: G = s * (pv+vp+stp+((otp/p)*otp)) 

Variables:
* [X] G = GAIAs
* [X] s = support achieved = ((Pangeans voting positive + Pangeans voting acceptance) / Pangeans)
* [X] pv = positive votes 
* [X] vp = vote participation (creator)
* [X] stp = same type proposals (creator - consensus reached) 
* [X] otp = other type proposals (creator - consensus reached)
* [X] p = total of proposals (creator - consensus reached)

Issues: however, there are several topics to improve the Formula, like:

. changes related of time

. will “support achieved” about all Pangeans or Pangeans with proposals or Pangeans with the same type of proposal...

**4. PROTOCOL**

The Pangea protocol is governed and upgraded by Pangeans (GAIA Token Holder Community), using the Consensus process to allow the community to propose, vote, and implement changes.

The on-chain protocol is implemented as a set of smart contracts structures to govern the movement of funds and smart contracts based decision-making, promoting security, self-custody, and to function without any trusted intermediaries. 

Pangea developers' contributions for the development, implementation and maintenance of the protocol are rewarded with GAIA tokens.

A Design of Pangea’s app was deployed at "https://miro.com/app/board/uXjVM_rnBHs=/?share_link_id=291993881138"

A Prototype of the Protocol was deployed at "Solidity Code/remix-backup-at-11h10min-2023-6-4" 

*Smart Contracts:*

GAIA token.sol: is the implementer of the GAIA token, the transactions of the Pangea ecosystem are executed through it.
                
PANGEA voting.sol: is an abstract contract from which Pangeans can vote and reach consensus. 

Parcel mint.sol and Parcel data.sol: are the implementers of the NFT - ERC721 token, they allows to swap assets.

**5. CONSENSUS**

The purpose of the Consensus process is to establish a formal discussion around a proposal and determine if there is enough support to make changes. Consensus means that complete agreement is needed, and it is not easy; but it certainly solves the problem of deciding by majority, where a minority loses even by a small difference in votes. Consensus decision-making is a pillar of the Pangea community and promotes that any Pangean can put forward an innovative proposal using a collaborative and consensus-based process and the entire Pangean community is allowed to vote to consider and improve the proposal.

Different points of view are solved through the Consensus process, in line with the pre-written rules in the smart contract.

*Steps To create a Consensus process:*
1. Present a proposal to the Pangeans community in the "Consensus" app’s option, about a potential change in governance, code or releases (e.g: "Modifying the ERC721 implementation of ERC721Enumerable using a new variable SupplyEnum"). Proposals should include Information, Details, Links, Data (Discord or Git). 
2. Pangeans through voting indicate their interest in moving it forward. If there is just one negative vote with its justification, Consensus is not reached and a process of discussion is open. 

*Negative Vote(s) with justification*: when a different opinion arises through negative vote, an honest discussion process is opened where responding to questions and sharing viewpoints is necessary. Then, changes, an alternative or a new proposal would be applied.

**Proposal types**
1. *Governance*: Pangea is created to encourage philanthropy, as well as greater engagement between recipients and donors, creating value for them is the most important goal, and to perform it, we have the greatest power by working closely with each other, enabling co-creation to achieve flow in our growth and development. The types of Governance proposals are aimed at developing community rules and policies, discussions about Pangea’s mission or levels of actions to reward Pangeans related to the non-profit’s mission.

2. *Code*: our valuable developer talents will enable the creation of the best features to engage and interact with the real world. The main force fuelling tech advancements are developers creating Code proposals, based on that, as volunteer developers helping to improve the Pangea app and the Pangea ecosystem as well, we support best practices to develop and maintain the software, addressing the most innovative solutions to raise Consensus and to be implemented. Code proposal types are aimed at holding controls over token minting or distribution of tokens, new contracts to be allocated, process charitable funds by on-chain technology and voting done through on-chain or off-chain actions, among many others. 

3. *Release (light consensus)*: releases require a degree of "light" consensus process and limited “bureaucracy” just to facilitate the goals of releases; the absence of a negative vote(s) as the only requisite, allows its realization. Discussions that inform implementation processes, dates, milestones, review environment and packages still need to take place.

**6. CONCLUSIONS**

Governance and Incentives should be applied with Consensus, cryptocurrencies and tokens are free to transfer between wallets, empowering the Pangea community through it, but at this time, there isn’t a final model to mine GAIA tokens or defined costs about maintaining the on-chain infrastructure, it is a challenge for the Pangea community itself, the DAO should decide under what conditions, also, maybe some roles will be necessary, but again, this is a field to be defined by the Pangea Consensus process and governance proposals.

Furthermore, enabling philanthropic activity by humanitarian donations through smart contracts architecture allows the movement of previously hidden administrative and bureaucratic actions into the light of decentralized, effective and transparent processes; moreover, the nature of this system empowers distributed decision-making as well as new methods of cooperation.

