#cd "/home/roozbeh/MyApps/university/Term 4/SBU-AI-Challenge/Learning Requirements/DockerServer/src/main/java"
cd "src/main/java"
echo "Starting to build"
docker build -t sbu-ai-challenge-client-container .
echo "Built! Starting to run!"
#docker run -it --rm --name running-client-container sbu-ai-challenge-client-container
docker run --network host -d --rm --name $1 sbu-ai-challenge-client-container
echo "Ran!"