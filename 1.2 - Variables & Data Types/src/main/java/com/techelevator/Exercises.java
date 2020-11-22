package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;
		
		System.out.println("Remaining number of birds = " + remainingNumberOfBirds);

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		
		System.out.println("Extra number of birds = " + numberOfExtraBirds);
		
        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		
		int raccoonsPlaying = 3;
		int raccoonsLeaving = 2;
		int numberOfRaccoonsLeftPlaying = raccoonsPlaying - raccoonsLeaving;
		
		System.out.println("Number of raccoons left playing = " + numberOfRaccoonsLeftPlaying);

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberOfFewerBees = numberOfFlowers - numberOfBees;
		
		System.out.println("Number of fewer bees = " + numberOfFewerBees);
		
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int initialPigeonsEating = 1;
		int newPigeonsJoining = 1;
		int totalPigeonsEating = initialPigeonsEating + newPigeonsJoining;
		
		System.out.println("Total pigeons eating = " + totalPigeonsEating);
		
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int initialOwlsSitting = 3;
		int newOwlsJoining = 2;
		int totalOwlsSitting = initialOwlsSitting + newOwlsJoining;
		
		System.out.println("Total owls sitting = " + totalOwlsSitting);
		
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int beaversWorking = 2;
		int beaversLeavingToSwim = 1;
		int beaversStillWorking = beaversWorking - beaversLeavingToSwim;
		
		System.out.println("Beavers still working = " + beaversStillWorking);
		
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int toucansSitting = 2;
		int toucansJoining = 1;
		int totalToucans = toucansSitting + toucansJoining;
		
		System.out.println("Total toucans = " + totalToucans);
		
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int numberOfExtraSquirrels = numberOfSquirrels - numberOfNuts;
		
		System.out.println("Number of extra squirrels = " + numberOfExtraSquirrels);
		
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double foundQuarterValue = 25;
		double foundDimeValue = 10;
		double foundNickelValue = 2 * 5;
		double totalValueFoundInDollars = (foundQuarterValue + foundDimeValue + foundNickelValue) / 100;
		
		System.out.println("Total value found = $" + totalValueFoundInDollars);
		
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int brierMuffins = 18;
		int macadamsMuffins = 20;
		int flanneryMuffins = 17;
		int totalMuffinsBaked = brierMuffins + macadamsMuffins + flanneryMuffins;
		
		System.out.println("Total muffins baked = " + totalMuffinsBaked);
		
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double yoyoCostInDollars = 0.24;
		double whistleCostInDollars = 0.14;
		double totalSpentInDollars = yoyoCostInDollars + whistleCostInDollars;
		
		System.out.println("Total spent = $" + totalSpentInDollars);
		
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallowsUsed = largeMarshmallows + miniMarshmallows;
		
		System.out.println("Total marshmallows used = " + totalMarshmallowsUsed);
		
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int hiltSnowInches = 29;
		int brecknockSnowInches = 17;
		int extraSnowAtHilt = hiltSnowInches - brecknockSnowInches;
		
		System.out.println("Extra snow at Hilt's house, in inches = " + extraSnowAtHilt);
		
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		int initialDollars = 10;
		int truckCostInDollars = 3;
		int caseCostInDollars = 2;
		int dollarsRemaining = initialDollars - truckCostInDollars - caseCostInDollars;
		
		System.out.println("Money left = $" + dollarsRemaining);
		
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int initialMarbles = 16;
		int lostMarbles = 7;
		int remainingMarbles = initialMarbles - lostMarbles;
		
		System.out.println("Remaining marbles = " + remainingMarbles);
		
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int seashellsDesired = 25;
		int currentSeashells = 19;
		int seashellsToFind = seashellsDesired - currentSeashells;
		
		System.out.println("Seashells to find = " + seashellsToFind);
		
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;
		
		System.out.println("Number of green balloons = " + greenBalloons);
		
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int initialBooks = 38;
		int addedBooks = 10;
		int totalBooks = initialBooks + addedBooks;
		
		System.out.println("Books on shelf now = " + totalBooks);
		
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int singleBeeLegs = 6;
		int totalBees = 8;
		int totalBeeLegs = singleBeeLegs * totalBees;
		
		System.out.println("Number of legs total on 8 bees = " + totalBeeLegs);
		
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double coneCost = 0.99;
		double twoConesCost = coneCost * 2;
		
		System.out.println("Cost for two cones = $" + twoConesCost);
		
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int totalRocksForBorder = 125;
		int currentRocks = 64;
		int rocksStillNeeded = totalRocksForBorder - currentRocks;
		
		System.out.println("Rocks still needed = " + rocksStillNeeded);
		
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int initialHiltMarbles = 38;
		int lostHiltMarbles = 15;
		int remainingHiltMarbles = initialHiltMarbles - lostHiltMarbles;
		
		System.out.println("Hilt's remaining marbles = " + remainingHiltMarbles);
		
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int totalMilesInTrip = 78;
		int milesToGasStop = 32;
		int remainingMilesToConcert = totalMilesInTrip - milesToGasStop;
		
		System.out.println("Miles left to drive = " + remainingMilesToConcert);
		
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */

		int morningShovelTime = 90;
		int afternoonShovelTime = 45;
		int totalShovelTime = morningShovelTime + afternoonShovelTime;
		
		System.out.println("Total time spent shoveling, in minutes = " + totalShovelTime);
		
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		double hotDogCost = 0.50;
		double hotDogsPurchased = 6.00;
		double totalSpentOnHotDogs = hotDogCost * hotDogsPurchased;
		
		System.out.println("Total spent on hot dogs = $" + totalSpentOnHotDogs);
		
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		int totalMoney = 50;
		int singlePencilCost = 7;
		int possiblePencilsToPurchase = totalMoney / singlePencilCost;
		
		System.out.println("Number of pencils she can buy = " + possiblePencilsToPurchase);
		
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;
		
		System.out.println("Number of red butterflies seen = " + redButterflies);
		
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double moneyGiven = 100;
		double candyCost = 54;
		double moneyBack = (moneyGiven - candyCost) / 100;
		
		System.out.println("Money given back = $" + moneyBack);
		
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int initialTrees = 13;
		int newTrees = 12;
		int totalTrees = initialTrees + newTrees;
		
		System.out.println("Total future trees = " + totalTrees);
		
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int daysLeft = 2;
		int hoursInOneDay = 24;
		int hoursLeft = daysLeft * hoursInOneDay;
		
		System.out.println("Hours until she sees grandma = " + hoursLeft);
		
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int cousins = 4;
		int gumPerPerson = 5;
		int gumNeeded = cousins * gumPerPerson;
		
		System.out.println("Pieces of gum needed = " + gumNeeded);
		
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		int initialDanMoney = 3;
		int candyBarCost = 1;
		int remainingDanMoney = initialDanMoney - candyBarCost;
		
		System.out.println("Dan's remaining money = " + remainingDanMoney);
		
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boats = 5;
		int peoplePerBoat = 3;
		int totalPeopleInBoats = boats * peoplePerBoat;
		
		System.out.println("Total people in boats on lake = " + totalPeopleInBoats);
		
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int initialLegos = 380;
		int lostLegos = 57;
		int remainingLegos = initialLegos - lostLegos;
		
		System.out.println("Remaining Legos = " + remainingLegos);
		
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int muffinsDesired = 83;
		int muffinsBaked = 35;
		int muffinsNeeded = muffinsDesired - muffinsBaked;
		
		System.out.println("Muffins he should bake = " + muffinsNeeded);
		
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int extraWillyCrayons = willyCrayons - lucyCrayons;
		
		System.out.println("Willy's extra crayons = " + extraWillyCrayons);
		
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickersPerPage = 10;
		int pages = 22;
		int totalStickers = stickersPerPage * pages;
		
		System.out.println("Total stickers = " + totalStickers);
		
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		int totalCupcakes = 96;
		int children = 8;
		int cupcakesPerChild = totalCupcakes / children;
		
		System.out.println("Cupcakes per child = " + cupcakesPerChild);
		
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

		int totalCookies = 47;
		int cookiesPerJar = 6;
		int cookiesNotInJars = totalCookies % cookiesPerJar;
		
		System.out.println("Cookies not placed in jars = " + cookiesNotInJars);
		
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

		int totalCroissants = 59;
		int neighbors = 8;
		int remainingCroissants = totalCroissants % neighbors;
		
		System.out.println("Total remaining croissants = " + remainingCroissants);
				
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int totalOatmealCookies = 276;
		int cookiesPerTray = 12;
		int traysNeeded = totalOatmealCookies / cookiesPerTray;
		
		System.out.println("Trays needed = " + traysNeeded);
		
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int totalPretzels = 480;
		int pretzelsPerServing = 12;
		int totalServings = totalPretzels / pretzelsPerServing;
		
		System.out.println("Total servings = " + totalServings);
		
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int totalLemonCupcakes = 53;
		int cupcakesPerBox = 3;
		int totalBoxes = totalLemonCupcakes / cupcakesPerBox;
		
		System.out.println("Total boxes given away = " + totalBoxes);
		
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int preparedCarrotSticks = 74;
		int peopleEatingCarrots = 12;
		int remainingCarrotSticks = preparedCarrotSticks % peopleEatingCarrots;
		
		System.out.println("Remaining carrot sticks = " + remainingCarrotSticks);
		
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int totalBears = 98;
		int maxBearsPerShelf = 7;
		int filledShelves = totalBears / maxBearsPerShelf;
		
		System.out.println("Shelves filled = " + filledShelves);
		
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int totalPictures = 480;
		int maxPicturesPerAlbum = 20;
		int albumsNeeded = totalPictures / maxPicturesPerAlbum;
		
		System.out.println("Albums needed = " + albumsNeeded);
		
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int totalCards = 94;
		int maxCardsPerBox = 8;
		int filledBoxes = totalCards / maxCardsPerBox;
		int cardsInUnfilledBox = totalCards % maxCardsPerBox;
		
		System.out.println("Filled boxes = " + filledBoxes);
		System.out.println("Cards in unfilled box = " + cardsInUnfilledBox);
		
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int totalBooksToShelve = 210;
		int totalShelves = 10;
		int booksPerShelf = totalBooksToShelve / totalShelves;
		
		System.out.println("Books per shelf = " + booksPerShelf);
		
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		int croissantsBaked = 17;
		int totalGuests = 7;
		int croissantsPerGuest = croissantsBaked / totalGuests;
		
		System.out.println("Croissants per guest = " + croissantsPerGuest);
		
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

		double billFeetPaintedPerHour = (12 * 14) / 2.15;
		System.out.println("Bill's feet painted per hour = " + billFeetPaintedPerHour);
		
		double jillFeetPaintedPerHour = (12 * 14) / 1.90;
		System.out.println("Jill's feet painted per hour = " + jillFeetPaintedPerHour);
		
		double combinedFeetPaintedPerHour = billFeetPaintedPerHour + jillFeetPaintedPerHour;
		
		System.out.println("Combined feet painted per hour = " + combinedFeetPaintedPerHour);
		
		double feetInFiveRooms = (12 * 14) * 5;
		double totalTeamHoursForFiveRooms = feetInFiveRooms / combinedFeetPaintedPerHour;
		
		System.out.println("Hours for Bill and Jill to paint 5 rooms = " + totalTeamHoursForFiveRooms);
		
		double feetIn623Rooms = (12 * 14) * 623;
		double feetPaintedPerDay = combinedFeetPaintedPerHour * 8;
		double daysToPaint623Rooms = feetIn623Rooms / feetPaintedPerDay;
		
		System.out.println("Days to paint 623 rooms = " + daysToPaint623Rooms);
		
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

		String firstName = "Benjamin";
		String lastName = "Pilcher";
		String middleInitial = "J";
		String fullName = lastName + ", " + firstName + " " + middleInitial + ".";
		
		System.out.println("My full name = " + fullName);
		
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */

		double totalMiles = 800;
		double milesTravelled = 537;
		double percentageCompleted = milesTravelled / totalMiles;
		
		System.out.println("Percentage of trip completed = " + (int)(percentageCompleted * 100) + "%");
	}

}
