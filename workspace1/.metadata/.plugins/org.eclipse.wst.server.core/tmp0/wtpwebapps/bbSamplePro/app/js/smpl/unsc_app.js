var scores = [84, 99, 91, 65, 87, 55, 72, 68, 95, 42], 
topScorers = [], scoreLimit = 90;
 
for (i=0; i<=scores.length; i++)
{
    if (scores[i]>scoreLimit)
    {
        topScorers.push(scores[i]);
    }
}
 
console.log(topScorers);