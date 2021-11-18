import requests as req
import argparse




if __name__=="__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("date",help = "DATE")
    parser.add_argument("id",help = "ID")
    

    args = parser.parse_args()
    print(args.date)
    print(args.id)
    
    n1 = str(args.date)
    n2 = int(args.id)
    


    data = req.get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2015-6-3&api_key=nhJIZme5Uzut9dJ7C8OBXRryfKjgcrTQTDa3jM72")
    data = data.json()
    x = data['photos']

    

    while(i>=0):
        a = x[i]
        lid = a['id']
        img = a['img_src']
        p = "'"+img+"'"
        print(p)
        l=len(a)


        if(args.id == lid):
            print("this")       
            r = req.get(p)

            with open("marspic.jpg",'wb') as f:
                f.write(r.content)
            print("this is happening")
        i = i + l

        if(i == l-1):
            break
