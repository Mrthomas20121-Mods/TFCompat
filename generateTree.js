const fs = require('fs');

let WOOD_TYPES = {
    'acacia': 'acacia',
    'ash': 'normal',
    'aspen': 'normal',
    'birch': 'normal',
    'blackwood': 'tall',
    'chestnut': 'normal',
    'douglas_fir': 'tallXL',
    'hickory': 'normal',
    'maple': 'normal',
    'oak': 'tallXL',
    'palm': 'tropical',
    'pine': 'conifer',
    'rosewood': 'tall',
    'sequoia': 'sequoia',
    'spruce': 'conifer',
    'sycamore': 'normal',
    'white_cedar': 'tall',
    'willow': 'willow',
    'kapok': 'jungle'
}


for(let woodType of Object.keys(WOOD_TYPES))
{
    genChairModel(woodType)
    genTableModel(woodType)
}

function genTableModel(woodType)
{
    const name = `table_${woodType}`
    const folder = "./src/main/resources/assets/tfcompat"
    const tfcWood = `tfc:blocks/wood/planks/${woodType}`
    const blockInventoryModel = getInventoryModel(tfcWood)
    const blockLegModel = getLegModel(tfcWood)
    const blockTopModel = getTopModel(tfcWood)
    const itemTableModel = getTableModel()
    const blockStateModel = getBlockStateModel(name)

    fs.writeFileSync(`${folder}/models/block/${name}_inventory.json`, JSON.stringify(blockInventoryModel, null, 2))
    fs.writeFileSync(`${folder}/models/block/${name}_leg_nw.json`, JSON.stringify(blockLegModel, null, 2))
    fs.writeFileSync(`${folder}/models/block/${name}_top.json`, JSON.stringify(blockTopModel, null, 2))
    fs.writeFileSync(`${folder}/models/item/${name}.json`, JSON.stringify(itemTableModel, null, 2))
    fs.writeFileSync(`${folder}/blockstates/${name}.json`, JSON.stringify(blockStateModel, null, 2))
}

function genChairModel(woodType='oak')
{
    const name = `chair_${woodType}`
    const folder = "./src/main/resources/assets/tfcompat"
    const tfcWood = `tfc:blocks/wood/planks/${woodType}`
    const blockmodel = getBlockModel(tfcWood)
    const itemModel = getItemModel(name)
    genBlockstates(name, folder)

    fs.writeFileSync(`${folder}/models/block/${name}.json`, JSON.stringify(blockmodel, null, 2))
    fs.writeFileSync(`${folder}/models/item/${name}.json`, JSON.stringify(itemModel, null, 2))
}

function genBlockstates(name, path)
{
    const model = getBlock(name)

    fs.writeFileSync(`${path}/blockstates/${name}.json`, JSON.stringify(model, null, 2))
}

function getTableModel()
{
    return {	"parent": "rusticbopwoods:block/table_cherry_inventory"	}
}

function getBlockStateModel(name)
{
    return {
        "multipart": [
            { "apply": {"model": `tfcompat:${name}_top`} },
            { "when": {"nw": "true"},
              "apply": {"model": `tfcompat:${name}_leg_nw`} },
            { "when": {"ne": "true"},
              "apply": {"model": `tfcompat:${name}_leg_nw`, "y": 90} },
            { "when": {"se": "true"},
              "apply": {"model": `tfcompat:${name}_leg_nw`, "y": 180} },
            { "when": {"sw": "true"},
              "apply": {"model": `tfcompat:${name}_leg_nw`, "y": 270} }
        ]
    }
}

function getTopModel(loc)
{
    return {
        "__comment": "Model generated using MrCrayfish's Model Creator (http://mrcrayfish.com/modelcreator/)",
        "textures": {
            "0": loc,
            "particle": loc
        },
        "elements": [
            {
                "name": "Cube",
                "from": [ 0.0, 14.0, 0.0 ], 
                "to": [ 16.0, 16.0, 16.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 16.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 16.0 ] }
                }
            }
        ]
    }
}

function getLegModel(loc)
{
    return {
        "__comment": "Model generated using MrCrayfish's Model Creator (http://mrcrayfish.com/modelcreator/)",
        "textures": {
            "0": loc
        },
        "elements": [
            {
                "name": "Cube",
                "from": [ 0.0, 0.0, 0.0 ], 
                "to": [ 2.0, 14.0, 2.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            }
        ]
    }
}

function getInventoryModel(loc)
{
    return {
        "__comment": "Model generated using MrCrayfish's Model Creator (http://mrcrayfish.com/modelcreator/)",
        "textures": {
            "0": loc
        },
        "elements": [
            {
                "name": "Cube",
                "from": [ 0.0, 0.0, 0.0 ], 
                "to": [ 2.0, 14.0, 2.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 14.0, 0.0, 0.0 ], 
                "to": [ 16.0, 14.0, 2.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 14.0, 0.0, 14.0 ], 
                "to": [ 16.0, 14.0, 16.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 0.0, 0.0, 14.0 ], 
                "to": [ 2.0, 14.0, 16.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 14.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 0.0, 14.0, 0.0 ], 
                "to": [ 16.0, 16.0, 16.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 2.0 ] },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 16.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 16.0, 16.0 ] }
                }
            }
        ],
        "display": {
    
            "gui": {
    
                "rotation": [ 30, 225, 0 ],
    
                "translation": [ 0, 0, 0],
    
                "scale":[ 0.625, 0.625, 0.625 ]
    
            },
            "ground": {
    
                "rotation": [ 0, 0, 0 ],
    
                "translation": [ 0, 3, 0],
    
                "scale":[ 0.25, 0.25, 0.25 ]
    
            },
    
            "fixed": {
    
                "rotation": [ 0, 0, 0 ],
    
                "translation": [ 0, 0, 0],
    
                "scale":[ 0.5, 0.5, 0.5 ]
    
            },
    
            "thirdperson_righthand": {
    
                "rotation": [ 75, 45, 0 ],
    
                "translation": [ 0, 2.5, 0],
    
                "scale": [ 0.375, 0.375, 0.375 ]
    
            },
    
            "firstperson_righthand": {
    
                "rotation": [ 0, 45, 0 ],
    
                "translation": [ 0, 0, 0 ],
    
                "scale": [ 0.40, 0.40, 0.40 ]
    
            },
    
            "firstperson_lefthand": {
    
                "rotation": [ 0, 225, 0 ],
    
                "translation": [ 0, 0, 0 ],
    
                "scale": [ 0.40, 0.40, 0.40 ]
    
            }
    
        }
    }
}

function getBlock(name)
{
    return {
        "variants": {
            "facing=north":	{ "model": `tfcompat:${name}` },
            "facing=east":	{ "model": `tfcompat:${name}`, "y": 90},
            "facing=south":	{ "model": `tfcompat:${name}`, "y": 180 },
            "facing=west":	{ "model": `tfcompat:${name}`, "y": 270 }
        }
    }
}

function getItemModel(name) {
    return {	"parent": `tfcompat:block/${name}`	}
}

function getBlockModel(woodLoc)
{
    return {
        "__comment": "Model generated using MrCrayfish's Model Creator (http://mrcrayfish.com/modelcreator/)",
        "textures": {
            "0": woodLoc,
            "particle": woodLoc
        },
        "elements": [
            {
                "name": "Cube",
                "from": [ 2.0, 0.0, 2.0 ], 
                "to": [ 4.0, 8.0, 4.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 12.0, 0.0, 2.0 ], 
                "to": [ 14.0, 8.0, 4.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 12.0, 0.0, 12.0 ], 
                "to": [ 14.0, 8.0, 14.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 2.0, 0.0, 12.0 ], 
                "to": [ 4.0, 8.0, 14.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 8.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 2.0, 8.0, 2.0 ], 
                "to": [ 14.0, 10.0, 14.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] },
                    "up": { "texture": "#0", "uv": [ 0.0, 3.0, 12.0, 15.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 3.0, 12.0, 15.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 2.0, 10.0, 12.0 ], 
                "to": [ 4.0, 16.0, 14.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 7.0, 10.0, 12.0 ], 
                "to": [ 9.0, 16.0, 14.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 12.0, 10.0, 12.0 ], 
                "to": [ 14.0, 16.0, 14.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 6.0, 2.0 ], "rotation": 90 },
                    "up": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "down": { "texture": "#-1", "uv": [ 0.0, 0.0, 2.0, 2.0 ] }
                }
            },
            {
                "name": "Cube",
                "from": [ 2.0, 16.0, 12.0 ], 
                "to": [ 14.0, 18.0, 14.0 ], 
                "faces": {
                    "north": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] },
                    "east": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "south": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] },
                    "west": { "texture": "#0", "uv": [ 0.0, 0.0, 2.0, 2.0 ] },
                    "up": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] },
                    "down": { "texture": "#0", "uv": [ 0.0, 0.0, 12.0, 2.0 ] }
                }
            }
        ],
        "display": {
    
            "gui": {
    
                "rotation": [ 30, 225, 0 ],
    
                "translation": [ 0, 0, 0],
    
                "scale":[ 0.625, 0.625, 0.625 ]
    
            },
            "ground": {
    
                "rotation": [ 0, 0, 0 ],
    
                "translation": [ 0, 3, 0],
    
                "scale":[ 0.25, 0.25, 0.25 ]
    
            },
    
            "fixed": {
    
                "rotation": [ 0, 0, 0 ],
    
                "translation": [ 0, 0, 0],
    
                "scale":[ 0.5, 0.5, 0.5 ]
    
            },
    
            "thirdperson_righthand": {
    
                "rotation": [ 75, 45, 0 ],
    
                "translation": [ 0, 2.5, 0],
    
                "scale": [ 0.375, 0.375, 0.375 ]
    
            },
    
            "firstperson_righthand": {
    
                "rotation": [ 0, 45, 0 ],
    
                "translation": [ 0, 0, 0 ],
    
                "scale": [ 0.40, 0.40, 0.40 ]
    
            },
    
            "firstperson_lefthand": {
    
                "rotation": [ 0, 225, 0 ],
    
                "translation": [ 0, 0, 0 ],
    
                "scale": [ 0.40, 0.40, 0.40 ]
    
            }
    
        }
    }
}