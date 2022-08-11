import pandas
import requests
df = pandas.DataFrame(pandas.read_excel(rf'isles.xlsx'), columns=['x_coordinate', 'y_coordinate', 'name', 'description', 'neighborhood'])
df.fillna(value='', inplace=True)
dicts = df.to_dict('records')
print(dicts)
headers = {
    'Content-type': 'application/json',
    'Accept': 'application/json'
}
for i in dicts:
    print(requests.post('https://api-sot.herokuapp.com/isles/', json=i, auth=('lucas', '123456'), headers=headers))
    print(i)