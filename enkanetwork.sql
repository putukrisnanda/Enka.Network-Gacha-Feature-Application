-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2023 at 06:50 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enkanetwork`
--

-- --------------------------------------------------------

--
-- Table structure for table `characterlore`
--

CREATE TABLE `characterlore` (
  `CharacterName` varchar(255) NOT NULL,
  `CharacterVision` varchar(100) NOT NULL,
  `CharacterConstelation` varchar(100) NOT NULL,
  `CharacterDescription` varchar(2500) NOT NULL,
  `CharacterValue` int(11) NOT NULL,
  `characterImage` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `characterlore`
--

INSERT INTO `characterlore` (`CharacterName`, `CharacterVision`, `CharacterConstelation`, `CharacterDescription`, `CharacterValue`, `characterImage`) VALUES
('Ganyu', 'Cryo', 'Sinae Unicornis', 'Ganyu is usually very meek, mild-mannered, and reserved due to her half-qilin heritage, and is easily flustered. She also completes whatever is given to her, whether it be tasks or food, even if she is reluctant to do so. Privately, she tends to snap whenever people speak ill of Beidou or the Geo Archon. She greatly respects her fellow adepti, especially Xiao and Cloud Retainer, seeing them as a mentor and a maternal figure respectively, although she becomes extremely anxious in the latter\'s presence due to her tendency to unintentionally ramble.', 254, 'file:src/MainClass_GenshinGacha/Genshin Impact/ganyu.png'),
('Hu Tao', 'Pyro', 'Papilio Charontis', 'At first glance, Hu Tao appears to be a quirky and cheerful girl. She enjoys pranking people and despises sitting around and doing nothing. She wishes to live her life to the fullest. Her eccentric and off-the-wall personality often leaves people with a negative impression of her, especially Qiqi, who states that she has a \"punchable face\" and should be stored in the fridge. In contrast, Xiao enjoys her sense of humor, finding it irritating but interesting.', 660, 'file:src/MainClass_GenshinGacha/Genshin Impact/hutao.png'),
('Kaedehara Kazuha', 'Anemo', 'Acer Palmatum', 'Kazuha is a polite and well-spoken person. Unlike other noble Inazuman clan members, he prefers going out and traveling rather than staying put indoors, something that he is able to do due to the seizure of his clan home. He once roamed Inazuma peacefully as a modest wanderer for a good portion of his life, teaching himself bladework and picking up other skills. Never seeking luxury, he is instead easily pleased just by sleeping on a sun-warmed rock. The time he has spent outdoors makes him attuned to nature and the wind, being able to \"hear\" and \"smell\" everything around him with absolute clarity. He can sense dangers, read people and track them down in an instant no matter how well they try to conceal it. Due to this sensitivity he prefers calm weather and never stays in one place for too long, having trouble sleeping for the former and having his skills stagnate for the latter.', 332, 'file:src/MainClass_GenshinGacha/Genshin Impact/kaedahara kazuha.png'),
('Yelan', 'Hydro', 'Umbrabilis Orchis', 'Yelan is said to be quite secretive and mysterious; while claiming to work for the Ministry of Civil Affairs, she\\\'s frequently absent from work most of the year. Despite this, Ningguang tolerates her general absence while Keqing appreciates her work, although the latter wonders as to where she gets her intelligence from. She employs psychological tactics to catch her targets and get all the information she needs from them.', 248, 'file:src/MainClass_GenshinGacha/Genshin Impact/yelan.png'),
('Yae Miko', 'Electro', 'Divina Vulpes', 'Miko has a mysterious demeanor around her whenever she assumes her duties as the Guuji of the Grand Narukami Shrine. When she assumes her duties as the boss of the Yae Publishing House, she is known to be very kind and enjoys reading books and stories, although she also shows an obsessive side in making profits at the same time. She has an enigmatic air around her, with her friends growing used to it. When speaking with outsiders or close friends, she shows a blunter and more cynical side to her. Miko does not mince words, even towards her friend and master Ei. Being a kitsune, Miko is fond of fried tofu. She despises pickled foods of all sorts.', 268, 'file:src/MainClass_GenshinGacha/Genshin Impact/yae miko.png'),
('Xiao', 'Anemo', 'Alatus Nemeseos', 'Xiao is a yaksha who has fought in the Archon War and holds a high level of seniority among adepti. He has a reserved demeanor and has little intention of getting close to mortals. He does not want sympathy for his past and believes his fellow Yakshas would also find it insulting.', 344, 'file:src/MainClass_GenshinGacha/Genshin Impact/xiao.png'),
('Raiden Shogun', 'Electro', 'Imperatrix Umbrosa', 'The Raiden Shogun is a firm believer of what she believes to be eternity — a place in which everything is kept the same, regardless of what goes on. She is honorable in her conduct and is revered by the people of Inazuma. The Raiden Shogun exists in two forms — Ei, her true identity, and the Shogun, a puppet created by Ei to oversee Inazuma in her stead while she meditates in the Plane of Euthymia. This puppet follows a set of directives programmed into her, which are extremely difficult to modify. The Shogun is cold and stern in personality, even callous at times; she is limited in emotional expression, has no likes and dislikes, and has no need for recreation.', 385, 'file:src/MainClass_GenshinGacha/Genshin Impact/raiden shogun.png');

-- --------------------------------------------------------

--
-- Table structure for table `ownedcharacter`
--

CREATE TABLE `ownedcharacter` (
  `OwnedCharacterName` varchar(255) NOT NULL,
  `OwnedCharacterVision` varchar(255) NOT NULL,
  `OwnedCharacterValue` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ownedcharacter`
--

INSERT INTO `ownedcharacter` (`OwnedCharacterName`, `OwnedCharacterVision`, `OwnedCharacterValue`) VALUES
('Kaedehara Kazuha', 'Anemo', 332),
('Yelan', 'Hydro', 248),
('Ganyu', 'Cryo', 254),
('Raiden Shogun', 'Electro', 385),
('Xiao', 'Anemo', 344);

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `UserID` char(5) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `UserGender` varchar(100) NOT NULL,
  `UserPassword` varchar(50) NOT NULL,
  `DiamondValue` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`UserID`, `Username`, `UserGender`, `UserPassword`, `DiamondValue`) VALUES
('VS001', 'Foedoe', 'Male', 'SigmaFigma', 2159);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
